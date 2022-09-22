package com.fishep.fusion.order.application.assembler.impl;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.order.application.assembler.OrderAssembler;
import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.common.type.ProductId;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderAssemblerImpl implements OrderAssembler {

    @Override
    public OrderDTO toDTO(Order order) {
        return null;
    }

    @Override
    public Product OrderProductAssembler(ProductId productId, Integer productCount, Currency currency) {
        return null;
    }
}
