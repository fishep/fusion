package com.fishep.fusion.order.application.assembler;

import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.domain.entity.Order;

public interface OrderAssembler {

    OrderDTO toDTO(Order order);

}
