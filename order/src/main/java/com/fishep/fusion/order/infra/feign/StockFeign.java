package com.fishep.fusion.order.infra.feign;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.order.infra.feign.impl.StockFeignImpl;
import com.fishep.fusion.order.infra.feign.request.StockRequest;
import com.fishep.fusion.order.infra.feign.request.StockSaveRequest;
import com.fishep.fusion.order.infra.feign.response.StockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "stock-app", fallback = StockFeignImpl.class)
public interface StockFeign {

    @PostMapping("/api/stock/stocks/query")
    Result<List<StockResponse>> list(@RequestBody StockRequest request);

//    @PostMapping("/api/stock/stocks/save")
//    Result<Boolean> save(@RequestBody StockSaveRequest request);

    @PostMapping("/api/stock/stocks/save")
    Result<Boolean> save(@RequestBody List<StockSaveRequest> request);
}
