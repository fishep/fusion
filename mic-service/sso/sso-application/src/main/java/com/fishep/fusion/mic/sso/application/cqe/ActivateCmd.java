package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.factory.IdentifierFactory;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2024/12/19 11:26
 * @Desc
 **/
@Data
public abstract class ActivateCmd {

    public String identifier;

    public String verificationCode;

    public abstract <T extends User> Class<T> getUserType();

    public Identifier getIdentifierEntity() {
        return IdentifierFactory.create(identifier);
    }

    public VerificationCode getVerificationCodeEntity(CertificateHashService certificateHashService) {
        return (VerificationCode) CertificateFactory.create(verificationCode, certificateHashService);
    }

}
