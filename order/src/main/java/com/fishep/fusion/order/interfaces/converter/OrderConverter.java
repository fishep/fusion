package com.fishep.fusion.order.interfaces.converter;

import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.interfaces.response.CreateOrderResponse;

public interface OrderConverter {

    CreateOrderResponse toCreateOrderResponse(OrderDTO orderDTO);

}
