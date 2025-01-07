package com.fishep.fusion.mic.sso.domain.factory;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.Password;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/31 15:00
 * @Desc
 **/
class CertificateFactoryTest {

    private static CertificateHashService hashService = new CertificateHashServiceImpl();

    @Test
    void create() {
        assertThrows(ValidateException.class, ()->{ CertificateFactory.create(null, hashService); });
        assertThrows(ValidateException.class, ()->{ CertificateFactory.create("", hashService); });
        assertThrows(ValidateException.class, ()->{ CertificateFactory.create(" ", hashService); });
        assertThrows(ValidateException.class, ()->{ CertificateFactory.create("12345678", null); });

        assertInstanceOf(Password.class, CertificateFactory.create("12345678", hashService));
        assertInstanceOf(VerificationCode.class, CertificateFactory.create("123456", hashService));
    }

}