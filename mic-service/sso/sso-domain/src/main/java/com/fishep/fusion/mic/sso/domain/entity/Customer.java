package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.CustomerId;

/**
 * @Author fly.fei
 * @Date 2024/12/4 17:12
 * @Desc 客户
 **/
public class Customer extends User {

    // 其他属性
    private Object field;

    public Customer(CustomerId customerId) {
        super(customerId);
    }

}
