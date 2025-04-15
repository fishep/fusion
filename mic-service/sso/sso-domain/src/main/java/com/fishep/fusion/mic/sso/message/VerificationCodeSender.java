package com.fishep.fusion.mic.sso.message;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;

/**
 * @Author fly.fei
 * @Date 2025/4/7 14:52
 * @Desc
 **/
public interface VerificationCodeSender {

    <T extends Account> void send(App app, Identifier identifier, Class<T> userClass, VerificationCode code);

}
