package com.fishep.fusion.product.domain.repository;

import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.product.domain.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> find(List<ProductId> productIds);

}
