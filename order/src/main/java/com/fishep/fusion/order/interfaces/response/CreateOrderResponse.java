package com.fishep.fusion.order.interfaces.response;

import lombok.Data;

@Data
public class CreateOrderResponse {

    public Long orderId;

    public String orderNumber;

    public String createdAt;

    public String updatedAt;

}
