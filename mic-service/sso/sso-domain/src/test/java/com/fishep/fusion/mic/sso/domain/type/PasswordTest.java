package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/23 18:20
 * @Desc
 **/
class PasswordTest {

    private static CertificateHashService hashService = new CertificateHashServiceImpl();

    @Test
    void create() {
        assertThrows(ValidateException.class, () -> { new Password("1234567", hashService); });
        assertDoesNotThrow(() -> { new Password("12345678", hashService); });
        assertDoesNotThrow(() -> { new Password("abcdefgh", hashService); });
        assertDoesNotThrow(() -> { new Password("abcdefgh12345678", hashService); });
        assertDoesNotThrow(() -> { new Password("_Abcdefgh-12345678_", hashService); });

        assertDoesNotThrow(() -> { new Password("12345678abcdefgh"); });
    }

}