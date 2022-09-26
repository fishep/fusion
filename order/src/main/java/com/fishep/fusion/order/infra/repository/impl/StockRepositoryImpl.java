package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.entity.Stock;
import com.fishep.fusion.order.domain.repository.StockRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockRepositoryImpl implements StockRepository {

    @Override
    public List<Stock> find(List<OrderProduct> orderProducts) {
        return null;
    }

    @Override
    public Boolean save(List<Stock> stocks) {
        return null;
    }
}
