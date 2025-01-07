package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/1/3 17:18
 * @Desc 携带验证码的注册命令，将标识符和凭证注册到系统，验证码用以验证标识符为其所有
 **/
@Data
public abstract class RegisterWithCodeCmd extends RegisterCmd {

    public String verificationCode;

    public VerificationCode getVerificationCode(CertificateHashService certificateHashService) {
        return (VerificationCode) CertificateFactory.create(verificationCode, certificateHashService);
    }

}
