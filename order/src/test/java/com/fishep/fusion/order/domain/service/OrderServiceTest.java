package com.fishep.fusion.order.domain.service;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.ExchangeRate;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.order.common.type.ProductId;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.Product;
import com.fishep.fusion.order.domain.entity.Stock;
import com.fishep.fusion.order.domain.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    void generate() {
        Product product1 = new Product(1, new Money("CNY", 2));
        Product product2 = new Product(2, new Money("CNY", 1));
        Stock stock1 = new Stock(product1.getId(), 20);
        Stock stock2 = new Stock(product2.getId(), 10);

        Account account = new Account(new Money("CNY", 10000));

        Order order = new Order("OD20220922000001", new Currency("CNY"), account);
        order.addProduct(product1);
        order.addProduct(product2);

        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);

        ExchangeRate exchangeRate = new ExchangeRate(new Currency("CNY"), new Currency("CNY"), BigDecimal.ONE);

        OrderService orderService = new OrderServiceImpl();
        orderService.generate(order, account, exchangeRate, stocks);

        assertEquals(4, order.getAmount().getAmount());
        assertEquals(9996, account.getAmount().getAmount());
        assertEquals(19, stock1.getCount());
        assertEquals(8, stock2.getCount());

    }

}