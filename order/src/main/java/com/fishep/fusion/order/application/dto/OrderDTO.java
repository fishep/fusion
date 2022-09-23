package com.fishep.fusion.order.application.dto;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.OrderId;
import com.fishep.fusion.common.type.OrderNumber;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private OrderId id;

    private AccountId accountId;

    private OrderNumber number;

    private Money amount;

    private List<OrderProduct> orderProducts;

    private Instant createdAt;

    private Instant updatedAt;

}
