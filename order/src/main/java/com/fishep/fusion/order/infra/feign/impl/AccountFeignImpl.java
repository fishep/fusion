package com.fishep.fusion.order.infra.feign.impl;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.order.infra.feign.AccountFeign;
import com.fishep.fusion.order.infra.feign.request.AccountUpdateRequest;
import com.fishep.fusion.order.infra.feign.response.AccountResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountFeignImpl implements AccountFeign {

    @Override
    public Result<AccountResponse> one(Long id) {
        return new Result<>(400, "服务不可达,服务降级,AccountFeign one(Long id), " + id);
    }

    @Override
    public Result<Boolean> save(Long id, AccountUpdateRequest request) {
        return new Result<>(400, "服务不可达,服务降级,AccountFeign save(Long id, AccountUpdateRequest request), " + id + request);
    }
}
