package com.fishep.fusion.order.infra.feign.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockResponse {

    public Long id;

    public Long productId;

    public Integer count;

    public String unit;

    public String createdAt;

    public String updatedAt;

}
