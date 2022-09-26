package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<OrderProduct> flush(List<OrderProduct> orderProducts) {
        return null;
    }
}
