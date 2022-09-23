package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Quantity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderProductTest {

    @Test
    void newProduct() {

        OrderProduct orderProduct = new OrderProduct(new ProductId(), new Quantity(Quantity.Unit.PIECES, 2), new Money("CNY", 2));

        assertNotNull(orderProduct.getId().getValue());
        assertEquals(2, orderProduct.getPrice().getValue());
        assertEquals(4, orderProduct.totalPrice().getValue());

        orderProduct.setCount(new Quantity(Quantity.Unit.PIECES, 3));
        assertEquals(6, orderProduct.totalPrice().getValue());
    }

}