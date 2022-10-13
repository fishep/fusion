package com.fishep.fusion.stock.interfaces.api;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.type.StockId;
import com.fishep.fusion.stock.interfaces.request.StockRequest;
import com.fishep.fusion.stock.interfaces.request.StockSaveRequest;
import com.fishep.fusion.stock.interfaces.response.StockResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/api/stock")
public class StockController {

    @PostMapping("/stocks/query")
    public Result<List<StockResponse>> list(@RequestBody StockRequest request) {

        List<StockResponse> response = new ArrayList<>();

        for (Long pid : request.productId) {
            response.add(
                    new StockResponse(
                            new StockId().getValue(),
                            pid,
                            new Random().nextInt(10) + 10, // [0, 20)
                            "PCS",
                            Instant.ofEpochSecond(1664183128).toString(),
                            Instant.ofEpochSecond(1664183128).toString()
                    )
            );
        }

        return new Result<>(200, "stock info", response);
    }

//    @PostMapping("/stocks/save")
//    public Result<Boolean> save(@RequestBody StockSaveRequest request){
//        return new Result<>(200, "save stock success!", Boolean.TRUE);
//    }

    @PostMapping("/stocks/save")
    public Result<Boolean> save(@RequestBody List<StockSaveRequest> request) {
        return new Result<>(200, "save stock success!", Boolean.TRUE);
    }

}
