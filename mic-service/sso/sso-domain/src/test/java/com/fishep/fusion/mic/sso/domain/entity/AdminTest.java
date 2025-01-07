package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.AdminId;
import com.fishep.fusion.mic.sso.domain.type.UserName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/26 14:27
 * @Desc
 **/
class AdminTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> { new Admin(); });
        assertDoesNotThrow(() -> { new Admin(new AdminId()); });
        assertDoesNotThrow(() -> { new Admin(new AdminId(), new UserName("test")); });
    }

}