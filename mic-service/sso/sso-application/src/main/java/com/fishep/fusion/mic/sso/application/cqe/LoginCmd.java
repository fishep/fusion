package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.factory.IdentifierFactory;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2024/12/18 18:20
 * @Desc
 **/
@Data
public abstract class LoginCmd {

    public String identifier;

    public String certificate;

    public abstract <T extends User> Class<T> getUserType();

    public Identifier getIdentifierEntity() {
        return IdentifierFactory.create(identifier);
    }

    public Certificate getCertificateEntity(CertificateHashService certificateHashService) {
        return CertificateFactory.create(certificate, certificateHashService);
    }

}
