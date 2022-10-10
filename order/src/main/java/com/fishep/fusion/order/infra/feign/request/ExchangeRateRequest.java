package com.fishep.fusion.order.infra.feign.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateRequest {

    public String source; // CNY, USD

    public String target; // USD, CNY

}
