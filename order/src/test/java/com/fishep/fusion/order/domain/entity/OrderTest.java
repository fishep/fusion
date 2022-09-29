package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void newOrder() {

        Account account = new Account(new Money("CNY", 10000));
        List<OrderProduct> orderProducts = new ArrayList<>();
        orderProducts.add(new OrderProduct(new ProductId(), new Quantity(Unit.PIECES, 1), new Money("CNY", 2)));
        orderProducts.add(new OrderProduct(new ProductId(), new Quantity(Unit.PIECES, 2), new Money("CNY", 3)));

        Order order = new Order(new Currency("CNY"), account.getId(), orderProducts);
        assertNotNull(order.getId().getValue());
        assertEquals(8, order.getAmount().getValue());

        order.addProduct(new OrderProduct(new ProductId(), new Quantity(Unit.PIECES, 3), new Money("CNY", 4)));
        assertEquals(20, order.getAmount().getValue());

        assertThrows(Exception.class, () -> {
            order.addProduct(new OrderProduct(new ProductId(), new Quantity(Unit.PIECES, 1), new Money("USD", 1)));
        });

    }
}