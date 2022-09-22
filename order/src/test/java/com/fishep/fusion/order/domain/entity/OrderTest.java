package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.Money;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void newOrder() {

        Account account = new Account(new Money("CNY", 10000));
        String orderNumber = "OD20220922000001";
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, new Money("CNY", 2)));
        products.add(new Product(2, new Money("CNY", 3)));

        Order order = new Order(orderNumber, new Currency("CNY"), account, products);
        assertNotNull(order.getId().getId());
        assertEquals(8, order.getAmount().getAmount());

        order.addProduct(new Product(3, new Money("CNY", 4)));
        assertEquals(20, order.getAmount().getAmount());

        assertThrows(Exception.class, ()->{
            order.addProduct(new Product(1, new Money("USD", 1)));
        });

    }
}