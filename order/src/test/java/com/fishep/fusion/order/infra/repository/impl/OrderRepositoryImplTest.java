package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Quantity;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class OrderRepositoryImplTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    void save() {
        Account account = new Account(new Money("CNY", 10000));
        List<OrderProduct> orderProducts = new ArrayList<>();
        orderProducts.add(new OrderProduct(new ProductId(), new Quantity(Quantity.Unit.PIECES, 1), new Money("CNY", 1)));
        orderProducts.add(new OrderProduct(new ProductId(), new Quantity(Quantity.Unit.PIECES, 2), new Money("CNY", 2)));

        Order order = new Order(new Currency("CNY"), account.getId(), orderProducts);

        Boolean ret = orderRepository.save(order);

        assertTrue(ret);
    }
}