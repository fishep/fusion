package com.fishep.fusion.product.infra.converter.impl;

import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Unit;
import com.fishep.fusion.product.domain.entity.Product;
import com.fishep.fusion.product.infra.converter.ProductBuilder;
import com.fishep.fusion.product.infra.model.ProductDO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductBuilderImpl implements ProductBuilder {

    @Override
    public List<Product> toProduct(List<ProductDO> pds) {
        List<Product> products = new ArrayList<>();

        for (ProductDO pdo : pds) {
            products.add(
                    new Product(
                            new ProductId(pdo.getId()),
                            pdo.getName(),
                            new Money(pdo.getCurrency(), pdo.getPrice()),
                            Unit.valueOf(pdo.getUnit()),
                            Instant.ofEpochSecond(pdo.getCreatedAt()),
                            Instant.ofEpochSecond(pdo.getUpdatedAt())
                    )
            );
        }

        return products;
    }
}
