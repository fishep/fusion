package com.fishep.fusion.common.util.impl;

import com.fishep.fusion.common.util.NumberBean;
import com.fishep.fusion.common.util.NumberFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class NumberFactoryImpl implements NumberFactory {

    @Autowired
    private RedisTemplate redisTemplate;

    private AbstractNumber abstractNumber;

    @Override
    public NumberBean create(String type) {

        if (type.equals("")) {
            throw new RuntimeException("NumberFactoryImpl create function parameter type is empty");
        }

        switch (type) {
            // Account Number
            case "account":
                abstractNumber = new AccountNumber();
                break;
            // Order Number
            case "order":
                abstractNumber = new OrderNumber();
                break;
            default:
                throw new RuntimeException("type: " + type + " is not exist");
//                break;
        }

        abstractNumber.setRedisTemplate(redisTemplate);

        return abstractNumber;
    }
}
