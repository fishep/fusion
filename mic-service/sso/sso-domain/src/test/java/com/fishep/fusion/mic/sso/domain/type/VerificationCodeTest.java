package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/23 18:21
 * @Desc
 **/
class VerificationCodeTest {

    private static CertificateHashService hashService = new CertificateHashServiceImpl();

    @Test
    void create() {
        assertThrows(ValidateException.class, () -> { new VerificationCode("12345", hashService); });
        assertThrows(ValidateException.class, () -> { new VerificationCode("1234567", hashService); });
        assertDoesNotThrow(() -> { new VerificationCode("123456", hashService); });
        assertDoesNotThrow(() -> { new VerificationCode("abcdef", hashService); });
        assertDoesNotThrow(() -> { new VerificationCode("abc123", hashService); });

        assertDoesNotThrow(() -> { new VerificationCode("12345678abcdefgh"); });
    }
    
}