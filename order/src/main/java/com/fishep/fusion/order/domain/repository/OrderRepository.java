package com.fishep.fusion.order.domain.repository;

import com.fishep.fusion.order.domain.entity.Order;

public interface OrderRepository {

    Boolean save(Order order);

}
