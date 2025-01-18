package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.CustomerId;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author fly.fei
 * @Date 2024/12/4 17:12
 * @Desc 客户
 **/
@Getter
@Setter
public class Customer extends User {

    // 其他属性
    @Getter
    @Setter
    private Object field;


    public Customer() {
        super(new CustomerId());
    }

    public Customer(CustomerId customerId) {
        super(customerId);
    }

    public Customer(CustomerId customerId, Identifier identifier) {
        super(customerId, identifier);
    }

}
