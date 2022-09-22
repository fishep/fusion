package com.fishep.fusion.order.domain.service;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.ExchangeRate;

public interface ExchangeRateService {

    ExchangeRate getExchangeRate(Currency source, Currency target);

}
