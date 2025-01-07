package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/23 18:20
 * @Desc
 **/
class UserNameTest {

    @Test
    void create() {
        assertThrows(ValidateException.class, () -> { new UserName(".test"); });
        assertThrows(ValidateException.class, () -> { new UserName("test."); });
        assertThrows(ValidateException.class, () -> { new UserName("1234.test"); });
        assertThrows(ValidateException.class, () -> { new UserName("test@email.com"); });
        assertThrows(ValidateException.class, () -> { new UserName("11111111111"); });
        assertDoesNotThrow(() -> { new UserName("test.test"); });
    }

}