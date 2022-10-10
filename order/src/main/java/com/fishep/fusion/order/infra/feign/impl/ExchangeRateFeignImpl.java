package com.fishep.fusion.order.infra.feign.impl;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.order.infra.feign.ExchangeRateFeign;
import com.fishep.fusion.order.infra.feign.request.ExchangeRateRequest;
import com.fishep.fusion.order.infra.feign.response.ExchangeRateResponse;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateFeignImpl implements ExchangeRateFeign {

    @Override
    public Result<ExchangeRateResponse> rate(ExchangeRateRequest request) {
        return new Result<>(400, "服务不可达,服务降级,ExchangeRateFeignImpl rate(ExchangeRateRequest request), " + request);
    }

}
