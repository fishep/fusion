package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author fly.fei
 * @Date 2024/12/26 11:59
 * @Desc
 **/
class CertificateTest {

    private static CertificateHashService hashService = new CertificateHashServiceImpl();

    private static String plaintext = "sometext";
    private static String ciphertext = "idontknow";

    @Test
    void createByPlaintext() {
        assertThrows(ValidateException.class, () -> { new Password(null, hashService); });
        assertThrows(ValidateException.class, () -> { new Password("", hashService); });
        assertThrows(ValidateException.class, () -> { new Password(" ", hashService); });
        assertDoesNotThrow(() -> { new Password(plaintext, hashService); });
        assertEquals(plaintext, new Password(plaintext, hashService).getPlaintext());
        assertNotNull(new Password(plaintext, hashService).getCiphertext());
    }

    @Test
    void createByCiphertext() {
        assertThrows(ValidateException.class, () -> { new Password(null); });
        assertThrows(ValidateException.class, () -> { new Password(""); });
        assertThrows(ValidateException.class, () -> { new Password(" "); });
        assertDoesNotThrow(() -> { new Password(ciphertext); });
        assertNull(new Password(ciphertext).getPlaintext());
        assertEquals(ciphertext, new Password(ciphertext).getCiphertext());
    }

    @Test
    void equals() {
        assertEquals(new Password(plaintext, hashService), new Password(plaintext, hashService));
        assertNotEquals(new Password(plaintext, hashService), new Password(ciphertext));
        assertEquals(new Password(ciphertext), new Password(ciphertext));
        assertNotEquals(new Password(ciphertext), new VerificationCode(ciphertext));
    }

}