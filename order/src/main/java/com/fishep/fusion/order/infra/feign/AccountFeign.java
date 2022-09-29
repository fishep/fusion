package com.fishep.fusion.order.infra.feign;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.order.infra.feign.impl.AccountFeignImpl;
import com.fishep.fusion.order.infra.feign.request.AccountUpdateRequest;
import com.fishep.fusion.order.infra.feign.response.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "user-app", fallback = AccountFeignImpl.class)
public interface AccountFeign {

    @GetMapping("/api/account/accounts/{id}")
    Result<AccountResponse> one(@PathVariable("id") Long id);

    @PostMapping("/api/account/accounts/{id}")
    Result<Boolean> save(@PathVariable("id") Long id, @RequestBody AccountUpdateRequest request);
}
