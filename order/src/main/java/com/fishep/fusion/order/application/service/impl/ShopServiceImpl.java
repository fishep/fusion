package com.fishep.fusion.order.application.service.impl;

import com.fishep.fusion.common.type.*;
import com.fishep.fusion.order.application.assembler.OrderAssembler;
import com.fishep.fusion.order.application.cqe.PlaceOrderCommand;
import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.application.service.ShopService;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.entity.Stock;
import com.fishep.fusion.order.domain.message.OrderCreated;
import com.fishep.fusion.order.domain.producer.OrderMessageProducer;
import com.fishep.fusion.order.domain.repository.AccountRepository;
import com.fishep.fusion.order.domain.repository.OrderRepository;
import com.fishep.fusion.order.domain.repository.ProductRepository;
import com.fishep.fusion.order.domain.repository.StockRepository;
import com.fishep.fusion.order.domain.service.ExchangeRateService;
import com.fishep.fusion.order.domain.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Validated
public class ShopServiceImpl implements ShopService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ExchangeRateService exchangeRateService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderAssembler orderAssembler;

    @Autowired
    OrderMessageProducer orderMessageProducer;

    @Override
    @GlobalTransactional(name = "gt", rollbackFor = Exception.class)
    public OrderDTO placeOrder(@Valid PlaceOrderCommand placeOrderCommand) {

        Currency currency = placeOrderCommand.getCurrency();
        AccountId accountId = placeOrderCommand.getAccountId();

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (PlaceOrderCommand.Product p : placeOrderCommand.getProducts()){
            OrderProduct orderProduct = new OrderProduct(p.getId(), p.getQuantity());
            orderProducts.add(orderProduct);
        }

        // 验证账户
        Account account = accountRepository.find(accountId);

        // 验证产品
        orderProducts = productRepository.flush(orderProducts);

        // 验证库存
        List<Stock> stocks = stockRepository.find(orderProducts);

        // 兑换服务
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(currency, account.getAmount().getCurrency());

        // 构建订单
        Order order = new Order(currency, accountId, orderProducts);

        // 订单业务
        orderService.generate(order, account, exchangeRate, stocks);

        // 持久化
        orderRepository.save(order);
        accountRepository.save(account);
        stockRepository.save(stocks);

        // 分发创建订单事件
        orderMessageProducer.send(new OrderCreated(account.getId(), order.getNumber()));

        // 对象转换
        OrderDTO orderDTO = orderAssembler.toDTO(order);

//        if (new Random().nextInt(0, 2) == 1){
//            throw new RuntimeException("throw test exception");
//        }
//        if (new Random().nextInt(5) == 1) {
//            throw new RuntimeException("throw test exception");
//        }

        return orderDTO;
    }
}
