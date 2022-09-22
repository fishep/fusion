package com.fishep.fusion.common.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    @Test
    void newCurrency() {

        Currency cny1 = new Currency(Currency.Code.CNY);
        Currency usd1 = new Currency(Currency.Code.USD);

        Currency cny2 = new Currency("CNY");
        Currency usd2 = new Currency("USD");

        assertThrows(Exception.class, ()->{
            new Currency("EUR");
        });

    }
}