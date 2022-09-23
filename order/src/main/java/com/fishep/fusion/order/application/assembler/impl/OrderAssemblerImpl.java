package com.fishep.fusion.order.application.assembler.impl;

import com.fishep.fusion.order.application.assembler.OrderAssembler;
import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.domain.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderAssemblerImpl implements OrderAssembler {

    @Override
    public OrderDTO toDTO(Order order) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setAccountId(order.getAccountId());
        orderDTO.setNumber(order.getNumber());
        orderDTO.setAmount(order.getAmount());
        orderDTO.setOrderProducts(order.getProducts());
        orderDTO.setCreatedAt(order.getCreatedAt());
        orderDTO.setUpdatedAt(order.getUpdatedAt());

        return orderDTO;
    }

}
