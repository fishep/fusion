package com.fishep.fusion.mic.sso.domain.type;

import cn.hutool.core.util.StrUtil;
import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2024/12/19 16:37
 * @Desc 表示一个证明，用来证明你是你，可以是密码，验证码，
 **/
@Getter
public abstract class Certificate {

    // 明文
    protected String plaintext;

    // 密文
    protected String ciphertext;

    protected Certificate(String ciphertext) {
        if (StrUtil.isBlank(ciphertext)) {
            throw new ValidateException("The Identifier ciphertext is Blank");
        }

        this.plaintext = null;
        this.ciphertext = ciphertext;
    }

    protected Certificate(String plaintext, CertificateHashService hashService) {
        if (StrUtil.isBlank(plaintext)) {
            throw new ValidateException("The Identifier is Blank");
        }
        if (hashService == null) {
            throw new ValidateException("The Identifier hashService is null");
        }

        this.plaintext = StrUtil.trim(plaintext);

        ciphertext = hashService.hash(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        if (ciphertext != null) {
            return ciphertext.equals(((Certificate) obj).ciphertext);
        }

        return false;
    }

}
