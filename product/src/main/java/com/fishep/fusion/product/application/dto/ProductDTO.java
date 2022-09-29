package com.fishep.fusion.product.application.dto;

import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ProductDTO {

    private ProductId id;

    private String name;

    private Money price;

    private Unit unit;

    private Instant createdAt;

    private Instant updatedAt;

}
