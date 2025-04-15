package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.AuthorizationCode;
import com.fishep.fusion.mic.sso.domain.type.Password;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/3/31 18:04
 * @Desc
 **/
@Data
public class RegisterWithAuthorizeCmd {

    public App app;

    public Account account;

    public Password password;

    public AuthorizationCode authorizationCode;

}
