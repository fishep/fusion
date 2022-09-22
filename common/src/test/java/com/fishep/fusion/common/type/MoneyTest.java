package com.fishep.fusion.common.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void newMoney() {

        Money money = new Money(new Currency("CNY"), 100);

        assertEquals(Currency.Code.CNY, money.getCurrency().getCode());
        assertEquals(100, money.getAmount());
    }
}