package com.fishep.fusion.order.domain.service;

import com.fishep.fusion.common.type.*;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.entity.Stock;
import com.fishep.fusion.order.domain.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceTest {

    @Test
    void generate() {
        OrderProduct orderProduct1 = new OrderProduct(new ProductId(), new Quantity(Quantity.Unit.PIECES, 1), new Money("CNY", 2));
        OrderProduct orderProduct2 = new OrderProduct(new ProductId(), new Quantity(Quantity.Unit.PIECES, 2), new Money("CNY", 1));
        Stock stock1 = new Stock(orderProduct1.getProductId(), new Quantity(Quantity.Unit.PIECES, 20));
        Stock stock2 = new Stock(orderProduct2.getProductId(), new Quantity(Quantity.Unit.PIECES, 10));

        Account account = new Account(new Money("CNY", 10000));

        Order order = new Order(new Currency("CNY"), account.getId());
        order.addProduct(orderProduct1);
        order.addProduct(orderProduct2);

        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);

        ExchangeRate exchangeRate = new ExchangeRate(new Currency("CNY"), new Currency("CNY"), BigDecimal.ONE);

        OrderService orderService = new OrderServiceImpl();
        orderService.generate(order, account, exchangeRate, stocks);

        assertEquals(4, order.getAmount().getValue());
        assertEquals(9996, account.getAmount().getValue());
        assertEquals(19, stock1.getCount().getValue());
        assertEquals(8, stock2.getCount().getValue());

    }

}