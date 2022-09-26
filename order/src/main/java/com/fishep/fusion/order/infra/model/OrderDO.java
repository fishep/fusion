package com.fishep.fusion.order.infra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDO {

    private Long id;

    private Long accountId;

    private String number;

    private String currency;

    private Integer amount;

    private Long createdAt;

    private Long updatedAt;

}
