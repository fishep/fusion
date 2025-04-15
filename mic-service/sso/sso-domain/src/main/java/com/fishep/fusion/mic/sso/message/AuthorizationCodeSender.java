package com.fishep.fusion.mic.sso.message;

import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.AuthorizationCode;

/**
 * @Author fly.fei
 * @Date 2025/4/7 15:15
 * @Desc
 **/
public interface AuthorizationCodeSender {

    void send(App app, AuthorizationCode code);

}
