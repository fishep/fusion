package com.fishep.fusion.user.interfaces.request;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.OrderNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedMessage {

    private AccountId accountId;

    private OrderNumber orderNumber;

}
