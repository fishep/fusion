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

        // ????????????
        Account account = accountRepository.find(accountId);

        // ????????????
        orderProducts = productRepository.flush(orderProducts);

        // ????????????
        List<Stock> stocks = stockRepository.find(orderProducts);

        // ????????????
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(currency, account.getAmount().getCurrency());

        // ????????????
        Order order = new Order(currency, accountId, orderProducts);

        // ????????????
        orderService.generate(order, account, exchangeRate, stocks);

        // ?????????
        orderRepository.save(order);
        accountRepository.save(account);
        stockRepository.save(stocks);

        // ????????????????????????
        orderMessageProducer.send(new OrderCreated(account.getId(), order.getNumber()));

        // ????????????
        OrderDTO orderDTO = orderAssembler.toDTO(order);

//        if (new Random().nextInt(0, 2) == 1){
//            throw new RuntimeException("throw test exception");
//        }
//        if (new Random().nextInt(5) == 1) {
//            throw new RuntimeException("throw test random exception");
//        }

        return orderDTO;
    }
}
