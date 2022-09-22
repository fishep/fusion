package com.fishep.fusion.order.domain.repository;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.Product;

import java.util.List;

public interface OrderRepository {

    Order build(Currency currency, List<Product> products);

    Boolean save(Order order);

}
