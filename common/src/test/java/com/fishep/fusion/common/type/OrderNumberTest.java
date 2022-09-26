package com.fishep.fusion.common.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderNumberTest {

    @Test
    void test() {
        OrderNumber orderNumber1 = new OrderNumber();
        OrderNumber orderNumber2 = new OrderNumber();
        OrderNumber orderNumber3 = new OrderNumber();

        System.out.println(orderNumber1.getValue());
        System.out.println(orderNumber2.getValue());
        System.out.println(orderNumber3.getValue());

        assertNotEquals(orderNumber1.getValue(), orderNumber2.getValue());
        assertNotEquals(orderNumber2.getValue(), orderNumber3.getValue());

    }
}