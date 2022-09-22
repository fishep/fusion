package com.fishep.fusion.common.type;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeRateTest {

    @Test
    void exchangeTest() {

        Money source1 = new Money(new Currency("CNY"), 10000);
        Money source2 = new Money(new Currency("USD"), 70000);

        ExchangeRate rate1 = new ExchangeRate(new Currency("CNY"), new Currency("CNY"), BigDecimal.ONE);
        ExchangeRate rate2 = new ExchangeRate(new Currency("CNY"), new Currency("USD"), BigDecimal.valueOf(0.1426));

        Money target1 = rate1.exchange(source1);
        assertEquals(Currency.Code.CNY, target1.getCurrency().getCode());
        assertEquals(10000, target1.getAmount());

        Money target2 = rate2.exchange(source1);
        assertEquals(Currency.Code.USD, target2.getCurrency().getCode());
        assertEquals(1426, target2.getAmount());

        assertThrows(Exception.class, ()->{
           rate2.exchange(source2);
        });

    }
}