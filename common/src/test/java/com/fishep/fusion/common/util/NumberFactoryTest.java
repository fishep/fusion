package com.fishep.fusion.common.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class NumberFactoryTest {

    @Autowired
    NumberFactory numberFactory;

    @Test
    void create() {
        String account = numberFactory.create("account").generate();
        assertEquals(16, account.toString().length());
        System.out.println("account number: " + account);

        String order = numberFactory.create("order").generate();
        assertEquals(16, order.toString().length());
        System.out.println("order number: " + order);
    }

}