package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Password;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/28 10:22
 * @Desc
 **/
class CertificateHashServiceTest {

    @Test
    void testCertificateHashServiceImpl() {
        CertificateHashService service = new CertificateHashServiceImpl();
        hash(service);
    }

    /**
     * 业务设定，不同类型的凭证使用不同类型的hash算法
     */
    void hash(CertificateHashService service) {

        assertNull(service.hash(null));

        Certificate password = new Password("12345678", service);
        assertNotNull(password.getCiphertext());
        assertEquals("PasswordHash", password.getCiphertext().substring(0, 12));

        Certificate verificationCode = new VerificationCode("123456", service);
        assertNotNull(verificationCode.getCiphertext());
        assertEquals("VerificationCodeHash", verificationCode.getCiphertext().substring(0, 20));
    }

}