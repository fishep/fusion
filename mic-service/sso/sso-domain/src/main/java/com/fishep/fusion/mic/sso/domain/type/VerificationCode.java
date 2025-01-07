package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;

/**
 * @Author fly.fei
 * @Date 2024/12/19 16:42
 * @Desc 验证码
 **/
public class VerificationCode extends Certificate {

    public VerificationCode(String ciphertext) {
        super(ciphertext);
    }

    public VerificationCode(String plaintext, CertificateHashService hashService) {
        super(plaintext, hashService);

        if (this.plaintext.length() != 6) {
            throw new ValidateException("The VerificationCode({}) does not comply with the specifications", plaintext);
        }
    }

}
