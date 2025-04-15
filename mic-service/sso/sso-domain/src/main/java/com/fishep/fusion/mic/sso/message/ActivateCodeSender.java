package com.fishep.fusion.mic.sso.message;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.type.ActivateCode;
import com.fishep.fusion.mic.sso.domain.type.App;

/**
 * @Author fly.fei
 * @Date 2025/4/3 18:04
 * @Desc
 **/
public interface ActivateCodeSender {

    void send(App app, Account account, ActivateCode code);

}
