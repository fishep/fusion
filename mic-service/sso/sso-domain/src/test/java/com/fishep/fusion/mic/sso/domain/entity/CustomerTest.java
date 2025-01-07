package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.CustomerId;
import com.fishep.fusion.mic.sso.domain.type.UserName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/26 14:29
 * @Desc
 **/
class CustomerTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> { new Customer(); });
        assertDoesNotThrow(() -> { new Customer(new CustomerId()); });
        assertDoesNotThrow(() -> { new Customer(new CustomerId(), new UserName("test")); });
    }

}