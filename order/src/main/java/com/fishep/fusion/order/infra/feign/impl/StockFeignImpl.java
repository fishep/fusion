package com.fishep.fusion.order.infra.feign.impl;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.order.infra.feign.StockFeign;
import com.fishep.fusion.order.infra.feign.request.StockRequest;
import com.fishep.fusion.order.infra.feign.request.StockSaveRequest;
import com.fishep.fusion.order.infra.feign.response.StockResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockFeignImpl implements StockFeign {

    @Override
    public Result<List<StockResponse>> list(StockRequest request) {
        return new Result<>(400, "服务不可达,服务降级,StockFeignImpl list(StockRequest request), " + request);
    }

//    @Override
//    public Result<Boolean> save(StockSaveRequest request) {
//        return new Result<>(400, "服务不可达,服务降级,StockFeignImpl save(StockSaveRequest request), " + request);
//    }

    @Override
    public Result<Boolean> save(List<StockSaveRequest> request) {
        return new Result<>(400, "服务不可达,服务降级,StockFeignImpl save(StockSaveRequest request), " + request);
    }
}
