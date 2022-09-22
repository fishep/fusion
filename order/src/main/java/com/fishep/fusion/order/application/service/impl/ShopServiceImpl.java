package com.fishep.fusion.order.application.service.impl;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.ExchangeRate;
import com.fishep.fusion.order.application.assembler.OrderAssembler;
import com.fishep.fusion.order.application.cqe.PlaceOrderCommand;
import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.application.service.ShopService;
import com.fishep.fusion.order.common.type.AccountId;
import com.fishep.fusion.order.common.type.ProductId;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.Product;
import com.fishep.fusion.order.domain.entity.Stock;
import com.fishep.fusion.order.domain.message.OrderCreated;
import com.fishep.fusion.order.domain.producer.OrderMessageProducer;
import com.fishep.fusion.order.domain.repository.AccountRepository;
import com.fishep.fusion.order.domain.repository.OrderRepository;
import com.fishep.fusion.order.domain.repository.ProductRepository;
import com.fishep.fusion.order.domain.repository.StockRepository;
import com.fishep.fusion.order.domain.service.ExchangeRateService;
import com.fishep.fusion.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public OrderDTO placeOrder(@Valid PlaceOrderCommand placeOrderCommand) {

        Currency currency = new Currency(placeOrderCommand.getCurrency());
        AccountId accountId = new AccountId(placeOrderCommand.getAccountId());
        List<Product> products = new ArrayList<>();
        for (PlaceOrderCommand.Product p : placeOrderCommand.getProducts()){
            Product product = orderAssembler.OrderProductAssembler(new ProductId(p.getProductId()), p.getProductCount(), currency);
            products.add(product);
        }

        // 验证账户
        Account account = accountRepository.find(accountId);

        // 验证产品
        productRepository.flush(products);

        // 验证库存
        List<Stock> stocks = stockRepository.find(products);

        // 兑换服务
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(currency, account.getAmount().getCurrency());

        // 构建订单
        Order order = orderRepository.build(currency, products);

        // 订单业务
        orderService.generate(order, account, exchangeRate, stocks);

        // 持久化
        orderRepository.save(order);
        accountRepository.save(account);
        stockRepository.save(stocks);

        // 分发创建订单事件
        orderMessageProducer.send(new OrderCreated());

        // 对象转换
        OrderDTO orderDTO = orderAssembler.toDTO(order);

        return orderDTO;
    }
}
