package com.fishep.fusion.mic.sso.domain.factory;

import cn.hutool.core.util.StrUtil;
import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.*;

/**
 * @Author fly.fei
 * @Date 2024/12/31 10:47
 * @Desc
 **/
public class CertificateFactory {

    private static CertificateHashService hashService = new CertificateHashServiceImpl();

    public static Certificate generate(Class<? extends Certificate> clazz) {
        if (Password.class.equals(clazz)) {
            return new Password("password", hashService);
        }

        if (VerificationCode.class.equals(clazz)) {
            return new VerificationCode("123456", hashService);
        }

        if (ActivateCode.class.equals(clazz)) {
            return new ActivateCode("123456", hashService);
        }

        if (AuthorizationCode.class.equals(clazz)) {
            return new AuthorizationCode("12345678abcdefgh12345678abcdefgh", hashService);
        }

        throw new ValidateException("Unsupported generate certificate types, certificate: {}", clazz.getName());
    }

    public static Certificate create(String plaintext, Class<? extends Certificate> clazz) {
        if (Password.class.equals(clazz)) {
            return new Password(plaintext, hashService);
        }

        if (VerificationCode.class.equals(clazz)) {
            return new VerificationCode(plaintext, hashService);
        }

        if (ActivateCode.class.equals(clazz)) {
            return new ActivateCode(plaintext, hashService);
        }

        if (AuthorizationCode.class.equals(clazz)) {
            return new AuthorizationCode(plaintext, hashService);
        }

        throw new ValidateException("Unsupported certificate types, certificate: {}", plaintext);
    }

    public static Certificate createLoginCertificate(String plaintext) {
        if (!StrUtil.isBlank(plaintext)) {
            if (plaintext.length() == 6) {
                return new VerificationCode(plaintext, hashService);
            }

            if (plaintext.length() >= 8) {
                return new Password(plaintext, hashService);
            }
        }

        throw new ValidateException("Unsupported certificate types, certificate: {}", plaintext);
    }
}
