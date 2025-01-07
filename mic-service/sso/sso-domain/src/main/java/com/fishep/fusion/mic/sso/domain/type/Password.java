package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;

/**
 * @Author fly.fei
 * @Date 2024/12/19 16:43
 * @Desc 密码
 **/
public class Password extends Certificate {

    public Password(String ciphertext) {
        super(ciphertext);
    }

    public Password(String plaintext, CertificateHashService hashService) {
        super(plaintext, hashService);

        if (this.plaintext.length() < 8) {
            throw new ValidateException("The password({}) does not comply with the specifications", plaintext);
        }
    }
}
