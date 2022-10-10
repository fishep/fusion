package com.fishep.fusion.finance.interfaces.request;

import lombok.Data;

@Data
public class ExchangeRateRequest {

    public String source; // CNY, USD

    public String target; // USD, CNY

}
