package com.fishep.fusion.order.infra.converter.impl;

import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.infra.converter.OrderBuilder;
import com.fishep.fusion.order.infra.model.OrderDO;
import com.fishep.fusion.order.infra.model.OrderProductDO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderBuilderImpl implements OrderBuilder {

    @Override
    public OrderDO toOrderDO(Order order) {

        OrderDO orderDO = new OrderDO();
        orderDO.setId(order.getId().getValue());
        orderDO.setAccountId(order.getAccountId().getValue());
        orderDO.setNumber(order.getNumber().getValue());
        orderDO.setCurrency(order.getAmount().getCurrency().getCodeName());
        orderDO.setAmount(order.getAmount().getValue());
        orderDO.setCreatedAt(order.getCreatedAt().getEpochSecond());
        orderDO.setUpdatedAt(order.getUpdatedAt().getEpochSecond());

        return orderDO;
    }

    @Override
    public List<OrderProductDO> toOrderProductDO(Order order) {

        List<OrderProductDO> products = new ArrayList<>();
        for (OrderProduct op : order.getProducts()) {
            OrderProductDO opDO = new OrderProductDO();
            opDO.setId(op.getId().getValue());
            opDO.setOrderId(order.getId().getValue());
            opDO.setCurrency(order.getAmount().getCurrency().getCodeName());
            opDO.setProductId(op.getProductId().getValue());
            opDO.setProductCount(op.getCount().getValue());
            opDO.setProductPrice(op.getPrice().getValue());
            opDO.setProductAmount(op.totalPrice().getValue());
            opDO.setCreatedAt(op.getCreatedAt().getEpochSecond());
            opDO.setUpdatedAt(op.getUpdatedAt().getEpochSecond());

            products.add(opDO);
        }

        return products;
    }
}
