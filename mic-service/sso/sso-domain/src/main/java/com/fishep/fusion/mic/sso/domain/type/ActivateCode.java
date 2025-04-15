package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;

/**
 * @Author fly.fei
 * @Date 2025/4/1 14:41
 * @Desc
 **/
public class ActivateCode extends Certificate {
    public ActivateCode(String ciphertext) {
        super(ciphertext);
    }

    public ActivateCode(String plaintext, CertificateHashService hashService) {
        super(plaintext, hashService);
    }
}
