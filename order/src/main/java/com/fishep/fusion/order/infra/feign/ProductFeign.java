package com.fishep.fusion.order.infra.feign;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.order.infra.feign.impl.ProductFeignImpl;
import com.fishep.fusion.order.infra.feign.request.ProductRequest;
import com.fishep.fusion.order.infra.feign.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "product-app", fallback = ProductFeignImpl.class)
public interface ProductFeign {

    @PostMapping("/api/product/products/query")
    Result<List<ProductResponse>> list(@RequestBody ProductRequest request);

}
