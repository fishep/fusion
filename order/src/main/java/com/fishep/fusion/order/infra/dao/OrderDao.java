package com.fishep.fusion.order.infra.dao;

import com.fishep.fusion.order.infra.model.OrderDO;
import com.fishep.fusion.order.infra.model.OrderProductDO;

import java.util.List;

public interface OrderDao {

    Boolean insert(OrderDO orderDO, List<OrderProductDO> orderProductDO);

}
