package com.fishep.fusion.order.infra.service.impl;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.ExchangeRate;
import com.fishep.fusion.order.domain.service.ExchangeRateService;
import com.fishep.fusion.order.infra.feign.ExchangeRateFeign;
import com.fishep.fusion.order.infra.feign.request.ExchangeRateRequest;
import com.fishep.fusion.order.infra.feign.response.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    ExchangeRateFeign exchangeRateFeign;

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {

        Result<ExchangeRateResponse> ret = exchangeRateFeign.rate(new ExchangeRateRequest(source.getCodeName(), target.getCodeName()));
        if (ret.getCode() != 200 || ret.getData() == null){
            throw new RuntimeException(ret.getMessage());
        }

        ExchangeRateResponse data = ret.getData();

        return new ExchangeRate(new Currency(data.getSource()), new Currency(data.getTarget()), data.getRate());
    }

}
