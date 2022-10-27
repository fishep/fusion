package com.fishep.fusion.gateway.feign;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.gateway.feign.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class UserClient {

//    @TODO 无法使用feign
    @Autowired
    UserFeign userFeign;

    public UserResponse one(Long id) {

        Result<UserResponse> result = userFeign.one(id);

        if (result.getData() == null) {
            throw new RuntimeException("user not exist, UserResponse one(Long id), id: " + id);
        }

        return result.getData();
    }

}
