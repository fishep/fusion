package com.fishep.fusion.product.infra.converter;

import com.fishep.fusion.product.domain.entity.Product;
import com.fishep.fusion.product.infra.model.ProductDO;

import java.util.List;

public interface ProductBuilder {

    List<Product> toProduct(List<ProductDO> pds);

}
