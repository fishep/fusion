package com.fishep.fusion.order.infra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDO {

    private Long id;

    private Long orderId;

    private String currency;

    private Long productId;

    private Integer productCount;

    private Integer productPrice;

    private Integer productAmount;

    private Long createdAt;

    private Long updatedAt;

}
