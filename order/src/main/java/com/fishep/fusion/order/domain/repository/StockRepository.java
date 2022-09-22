package com.fishep.fusion.order.domain.repository;

import com.fishep.fusion.order.domain.entity.Product;
import com.fishep.fusion.order.domain.entity.Stock;

import java.util.List;

public interface StockRepository {

    List<Stock> find(List<Product> products);

    Boolean save(List<Stock> stocks);

}
