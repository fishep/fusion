package com.fishep.fusion.order.domain.repository;

import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.entity.Stock;

import java.util.List;

public interface StockRepository {

    List<Stock> find(List<OrderProduct> orderProducts);

    Boolean save(List<Stock> stocks);

}
