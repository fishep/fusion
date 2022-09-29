package com.fishep.fusion.order.infra.repository.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Quantity;
import com.fishep.fusion.common.type.StockId;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.entity.Stock;
import com.fishep.fusion.order.domain.repository.StockRepository;
import com.fishep.fusion.order.infra.feign.StockFeign;
import com.fishep.fusion.order.infra.feign.request.StockRequest;
import com.fishep.fusion.order.infra.feign.request.StockSaveRequest;
import com.fishep.fusion.order.infra.feign.response.StockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockRepositoryImpl implements StockRepository {

    @Autowired
    StockFeign stockFeign;

    @Override
    public List<Stock> find(List<OrderProduct> orderProducts) {
        Long[] pids = new Long[orderProducts.size()];

        for (int i = 0; i < orderProducts.size(); i++){
            pids[i] = orderProducts.get(i).getProductId().getValue();
        }

        Result<List<StockResponse>> ret = stockFeign.list(new StockRequest(pids));
        if (ret.getCode() != 200 || ret.getData() == null){
            throw new RuntimeException(ret.getMessage());
        }

        List<Stock> stocks = new ArrayList<>();
        List<StockResponse> data = ret.getData();
        for (StockResponse sr : data){
            stocks.add(
                    new Stock(
                            new StockId(sr.getId()),
                            new ProductId(sr.getProductId()),
                            new Quantity(sr.getUnit(), sr.getCount()),
                            DateUtil.parse(sr.getCreatedAt(), DatePattern.UTC_PATTERN).toInstant(),
                            DateUtil.parse(sr.getUpdatedAt(), DatePattern.UTC_PATTERN).toInstant()
                    )
            );
        }

        return stocks;
    }

    @Override
    public Boolean save(List<Stock> stocks) {
        List<StockSaveRequest> rs = new ArrayList<>();
        for (Stock stock : stocks){
            rs.add(
                    new StockSaveRequest(stock.getId().getValue(), stock.getCount().getValue())
            );
        }

        Result<Boolean> ret = stockFeign.save(rs);
        if (ret.getCode() != 200 || !ret.getData()){
            throw new RuntimeException(ret.getMessage());
        }

        return Boolean.TRUE;
    }
}
