package com.fishep.fusion.mic.sso.domain.type;

import cn.hutool.json.JSON;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/4/1 14:40
 * @Desc
 **/
@Data
public class AuthorizationCode extends Certificate {

    public JSON body;

    public AuthorizationCode(String ciphertext) {
        super(ciphertext);
    }

    public AuthorizationCode(String plaintext, CertificateHashService hashService) {
        super(plaintext, hashService);
    }

}
