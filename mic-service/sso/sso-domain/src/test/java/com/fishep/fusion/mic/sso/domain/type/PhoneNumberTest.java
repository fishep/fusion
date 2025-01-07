package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/23 18:20
 * @Desc
 **/
class PhoneNumberTest {

    @Test
    void create() {
        assertThrows(ValidateException.class, () -> { new PhoneNumber("test"); });
        assertThrows(ValidateException.class, () -> { new PhoneNumber("1234567898"); });
        assertThrows(ValidateException.class, () -> { new PhoneNumber("123456789876"); });
        assertThrows(ValidateException.class, () -> { new PhoneNumber("aaaaaaaaaaa"); });
        assertThrows(ValidateException.class, () -> { new PhoneNumber("test@email.com"); });
        assertThrows(ValidateException.class, () -> { new PhoneNumber("test.test"); });
        assertDoesNotThrow(() -> { new PhoneNumber("11111111111"); });
    }

}