package com.fishep.fusion.product.infra.repository.impl;

import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.product.domain.entity.Product;
import com.fishep.fusion.product.domain.repository.ProductRepository;
import com.fishep.fusion.product.infra.converter.ProductBuilder;
import com.fishep.fusion.product.infra.dao.ProductDao;
import com.fishep.fusion.product.infra.model.ProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductBuilder productBuilder;

    @Override
    public List<Product> find(List<ProductId> productIds) {

        if (productIds.size() == 0){
            throw new RuntimeException("productIds is empty , productIds: " + productIds);
        }

        Long[] ids = new Long[productIds.size()];
        for (int i = 0; i < productIds.size(); i++){
            ids[i] = productIds.get(i).getValue();
        }

        List<ProductDO> pds = productDao.select(ids);

        List<Product> products = productBuilder.toProduct(pds);

        return products;
    }
}
