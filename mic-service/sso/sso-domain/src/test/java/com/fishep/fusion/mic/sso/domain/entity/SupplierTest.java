package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.SupplierId;
import com.fishep.fusion.mic.sso.domain.type.UserName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/26 14:29
 * @Desc
 **/
class SupplierTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> { new Supplier(); });
        assertDoesNotThrow(() -> { new Supplier(new SupplierId()); });
        assertDoesNotThrow(() -> { new Supplier(new SupplierId(), new UserName("test")); });
    }

}