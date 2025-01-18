package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.IdentifierFactory;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/1/4 11:56
 * @Desc
 **/
@Data
public abstract class SendVerificationCodeCmd {

    public String identifier;

    public abstract <T extends User> Class<T> getUserType();

    public Identifier getIdentifierEntity() {
        return IdentifierFactory.create(identifier);
    }

}
