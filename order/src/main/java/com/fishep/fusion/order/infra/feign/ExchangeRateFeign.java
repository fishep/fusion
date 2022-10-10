package com.fishep.fusion.order.infra.feign;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.order.infra.feign.impl.ExchangeRateFeignImpl;
import com.fishep.fusion.order.infra.feign.request.ExchangeRateRequest;
import com.fishep.fusion.order.infra.feign.response.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "finance-app", fallback = ExchangeRateFeignImpl.class)
public interface ExchangeRateFeign {

    @PostMapping("/api/finance/exchange/rate")
    Result<ExchangeRateResponse> rate(@RequestBody ExchangeRateRequest request);

}
