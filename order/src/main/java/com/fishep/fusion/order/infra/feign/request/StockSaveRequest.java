package com.fishep.fusion.order.infra.feign.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockSaveRequest {

    public Long id;

    public Integer count;

}
