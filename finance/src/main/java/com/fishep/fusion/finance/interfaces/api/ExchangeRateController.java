package com.fishep.fusion.finance.interfaces.api;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.finance.interfaces.request.ExchangeRateRequest;
import com.fishep.fusion.finance.interfaces.response.ExchangeRateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;

@Slf4j
@RestController
@RequestMapping("/api/finance")
public class ExchangeRateController {

    @PostMapping("/exchange/rate")
    public Result<ExchangeRateResponse> rate(@RequestBody ExchangeRateRequest request) {

        if (request.getSource().equals(request.getTarget())){
            ExchangeRateResponse data = new ExchangeRateResponse();
            data.setSource(request.getSource());
            data.setTarget(request.getTarget());
            data.setRate(BigDecimal.ONE);
            data.setTime(Instant.now().toString());

            return new Result<>(200, "exchange rate info", data);
        }

        if (request.getSource().equals("CNY") && request.getTarget().equals("USD")){
            ExchangeRateResponse data = new ExchangeRateResponse();
            data.setSource(request.getSource());
            data.setTarget(request.getTarget());
            data.setRate(BigDecimal.valueOf(0.1405));
            data.setTime(Instant.now().toString());

            return new Result<>(200, "CNY exchange USD rate info", data);

        }

        if (request.getSource().equals("USD") && request.getTarget().equals("CNY")){
            ExchangeRateResponse data = new ExchangeRateResponse();
            data.setSource(request.getSource());
            data.setTarget(request.getTarget());
            data.setRate(BigDecimal.valueOf(7.116));
            data.setTime(Instant.now().toString());

            return new Result<>(200, "USD exchange CNY rate info", data);
        }

        return new Result<>(400, "Unsupported exchange, request: " + request);
    }
}
