package com.fishep.fusion.order.interfaces.converter.impl;

import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.interfaces.converter.OrderConverter;
import com.fishep.fusion.order.interfaces.response.CreateOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderConverterImpl implements OrderConverter {

    @Override
    public CreateOrderResponse toCreateOrderResponse(OrderDTO orderDTO) {
        CreateOrderResponse response = new CreateOrderResponse();
        response.setOrderId(orderDTO.getId().getValue());
        response.setOrderNumber(orderDTO.getNumber().getValue());
        response.setCreatedAt(orderDTO.getCreatedAt().toString());
        response.setUpdatedAt(orderDTO.getUpdatedAt().toString());

        return response;
    }
}
