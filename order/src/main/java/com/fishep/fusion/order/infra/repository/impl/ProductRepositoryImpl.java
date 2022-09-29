package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.repository.ProductRepository;
import com.fishep.fusion.order.infra.feign.ProductFeign;
import com.fishep.fusion.order.infra.feign.request.ProductRequest;
import com.fishep.fusion.order.infra.feign.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    ProductFeign productFeign;

    @Override
    public List<OrderProduct> flush(List<OrderProduct> orderProducts) {

        Long[] id = new Long[orderProducts.size()];
        for (int i = 0; i < orderProducts.size(); i++){
            id[i] = orderProducts.get(i).getProductId().getValue();
        }

        Result<List<ProductResponse>> ret = productFeign.list(new ProductRequest(id));
        if (ret.getCode() != 200 || ret.getData() == null){
            throw new RuntimeException(ret.getMessage());
        }

        List<ProductResponse> data = ret.getData();
        for (ProductResponse p : data){
            for (OrderProduct op : orderProducts){
                if (Objects.equals(p.getId(), op.getProductId().getValue())){
                    op.changePrice(new Money(p.getCurrency(), p.getPrice()));
                }
            }
        }

        return orderProducts;
    }
}
