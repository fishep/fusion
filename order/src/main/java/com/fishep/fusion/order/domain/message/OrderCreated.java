package com.fishep.fusion.order.domain.message;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.OrderNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreated {

    private AccountId accountId;

    private OrderNumber orderNumber;

}
