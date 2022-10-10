package com.fishep.fusion.order.infra.service.impl;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.ExchangeRate;
import com.fishep.fusion.order.domain.service.ExchangeRateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
class ExchangeRateServiceImplTest {

    @Autowired
    ExchangeRateService exchangeRateService;

    @Test
    void getExchangeRate() {
        ExchangeRate rate1 = exchangeRateService.getExchangeRate(new Currency("CNY"), new Currency("CNY"));
        assertNotNull(rate1);

        ExchangeRate rate2 = exchangeRateService.getExchangeRate(new Currency("CNY"), new Currency("USD"));
        assertNotNull(rate2);

        ExchangeRate rate3 = exchangeRateService.getExchangeRate(new Currency("USD"), new Currency("CNY"));
        assertNotNull(rate3);

        assertThrows(Exception.class, () -> {
            exchangeRateService.getExchangeRate(new Currency("CNY"), new Currency("EUR"));
        });

    }
}