package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.IdentifierFactory;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.Identifier;

/**
 * @Author fly.fei
 * @Date 2024/12/18 18:20
 * @Desc
 **/
public abstract class LoginCmd {

    public String identifier;

    public abstract <T extends User> Class<T> getUserType();

    public Identifier getIdentifierInstance() {
        return IdentifierFactory.create(identifier);
    }

}
