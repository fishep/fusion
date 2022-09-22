package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.order.common.type.ProductId;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void newProduct() {

        Product product = new Product(new ProductId(), 2, new Money("CNY", 2), Instant.now(), Instant.now());

        assertNotNull(product.getId().getId());
        assertEquals(2, product.getPrice().getAmount());
        assertEquals(4, product.totalPrice().getAmount());

        product.setCount(3);
        assertEquals(6, product.totalPrice().getAmount());
    }

}