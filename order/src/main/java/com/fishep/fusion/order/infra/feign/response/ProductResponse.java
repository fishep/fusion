package com.fishep.fusion.order.infra.feign.response;

import lombok.Data;

@Data
public class ProductResponse {

    private Long id;

    private String name;

    private String currency;

    private Integer price;

    private String unit;

    private String createdAt;

    private String updatedAt;

}
