package com.fishep.fusion.gateway.feign;

//import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.gateway.feign.impl.UserFeignImpl;
import com.fishep.fusion.gateway.feign.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-app", fallback = UserFeignImpl.class)
public interface UserFeign {

//    @GetMapping("/api/user/user/users/{id}")
//    Result<UserResponse> one(@PathVariable("id") Long id);

}
