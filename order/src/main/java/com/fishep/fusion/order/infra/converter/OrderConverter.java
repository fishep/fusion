package com.fishep.fusion.order.infra.converter;

import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.infra.model.OrderDO;
import com.fishep.fusion.order.infra.model.OrderProductDO;

import java.util.List;

public interface OrderConverter {

    OrderDO toOrderDO(Order order);

    List<OrderProductDO> toOrderProductDO(Order order);

}
