package com.fishep.fusion.mic.sso.domain.factory;

import cn.hutool.core.util.StrUtil;
import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Password;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;

/**
 * @Author fly.fei
 * @Date 2024/12/31 10:47
 * @Desc
 **/
public class CertificateFactory {

    private CertificateHashService hashService;

    public CertificateFactory(CertificateHashService hashService) {
        this.hashService = hashService;
    }

    public Certificate create(String plaintext) {
        return create(plaintext, hashService);
    }

    public VerificationCode generateVerificationCode() {
        String plaintext = "123456";
        return (VerificationCode) create(plaintext, hashService);
    }

    public Password generatePassword() {
        String plaintext = "12345678";
        return (Password) create(plaintext, hashService);
    }

    public Certificate generate(Class<? extends Certificate> clazz) {
        if (Password.class.equals(clazz)) {
            return generatePassword();
        }

        if (VerificationCode.class.equals(clazz)) {
            return generateVerificationCode();
        }

        throw new ValidateException("Unsupported generate certificate types, certificate: {}", clazz.getName());
    }

    public static Certificate create(String plaintext, CertificateHashService hashService) {
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
