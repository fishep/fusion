package com.fishep.fusion.order.infra.dao.impl;

import com.fishep.fusion.order.infra.dao.OrderDao;
import com.fishep.fusion.order.infra.mapper.OrderMapper;
import com.fishep.fusion.order.infra.mapper.OrderProductMapper;
import com.fishep.fusion.order.infra.model.OrderDO;
import com.fishep.fusion.order.infra.model.OrderProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoMybatisImpl implements OrderDao {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderProductMapper orderProductMapper;

    @Override
    public Boolean insert(OrderDO orderDO, List<OrderProductDO> orderProductDOs) {

        if (!orderMapper.insert(orderDO)) {
            return Boolean.FALSE;
        }

        for (OrderProductDO op : orderProductDOs) {
            if (!orderProductMapper.insert(op)) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }
}
