package com.fishep.fusion.product.infra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDO {

    private Long id;

    private String name;

    private String currency;

    private Integer price;

    private String unit;

    private Long createdAt;

    private Long updatedAt;

}
