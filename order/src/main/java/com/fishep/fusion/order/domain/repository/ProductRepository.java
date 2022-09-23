package com.fishep.fusion.order.domain.repository;

import com.fishep.fusion.order.domain.entity.OrderProduct;

import java.util.List;

public interface ProductRepository {

    List<OrderProduct> flush(List<OrderProduct> orderProducts);

}
