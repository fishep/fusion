package com.fishep.fusion.order.infra.feign.impl;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.order.infra.feign.ProductFeign;
import com.fishep.fusion.order.infra.feign.request.ProductRequest;
import com.fishep.fusion.order.infra.feign.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFeignImpl implements ProductFeign {

    @Override
    public Result<List<ProductResponse>> list(ProductRequest request) {
        return new Result<>(400, "服务不可达,服务降级,ProductFeignImpl list(ProductRequest request), " + request);
    }
}
