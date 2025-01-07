package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/23 18:20
 * @Desc
 **/
class EmailTest {

    @Test
    void create() {
        assertThrows(ValidateException.class, () -> { new Email("test"); });
        assertThrows(ValidateException.class, () -> { new Email("test@"); });
        assertThrows(ValidateException.class, () -> { new Email("@email.com"); });
        assertThrows(ValidateException.class, () -> { new Email("test.test"); });
        assertThrows(ValidateException.class, () -> { new Email("11111111111"); });
        assertDoesNotThrow(() -> { new Email("test@email.com"); });
    }

}