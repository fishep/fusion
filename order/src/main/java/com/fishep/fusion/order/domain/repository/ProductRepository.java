package com.fishep.fusion.order.domain.repository;

import com.fishep.fusion.order.domain.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> flush(List<Product> products);

}
