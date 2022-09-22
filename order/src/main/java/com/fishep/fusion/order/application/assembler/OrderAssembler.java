package com.fishep.fusion.order.application.assembler;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.common.type.ProductId;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.Product;

public interface OrderAssembler {

    OrderDTO toDTO(Order order);

    Product OrderProductAssembler(ProductId productId, Integer productCount, Currency currency);

}
