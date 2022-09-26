package com.fishep.fusion.order.infra.service.impl;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.ExchangeRate;
import com.fishep.fusion.order.domain.service.ExchangeRateService;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        return null;
    }

}
