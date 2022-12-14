package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.repository.OrderRepository;
import com.fishep.fusion.order.infra.converter.OrderBuilder;
import com.fishep.fusion.order.infra.dao.OrderDao;
import com.fishep.fusion.order.infra.model.OrderDO;
import com.fishep.fusion.order.infra.model.OrderProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderBuilder orderBuilder;

    @Override
    public Boolean save(Order order) {

        OrderDO orderDO = orderBuilder.toOrderDO(order);

        List<OrderProductDO> orderProductDOs = orderBuilder.toOrderProductDO(order);

        if (!orderDao.insert(orderDO, orderProductDOs)){
            throw new RuntimeException("OrderRepositoryImpl save fail, order: " + order);
        }

        return Boolean.TRUE;
    }

}
