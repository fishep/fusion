package com.fishep.fusion.stock.interfaces.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockResponse {

    public Long id;

    public Long productId;

    public Integer count;

    public String unit;

    public String createdAt;

    public String updatedAt;

}
