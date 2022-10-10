package com.fishep.fusion.order.infra.feign.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateResponse {

    public String source; // CNY, USD

    public String target; // USD, CNY

    public BigDecimal rate; // 0.1405 , 7.116

    public String time; //

}
