package com.fishep.fusion.mic.sso.application.service;

import com.fishep.fusion.mic.sso.application.cqe.*;
import com.fishep.fusion.mic.sso.application.dto.AuthorizationCodeDto;
import com.fishep.fusion.mic.sso.application.dto.TokenDto;

/**
 * @Author fly.fei
 * @Date 2024/12/18 18:09
 * @Desc 认证流程
 **/
public interface AuthService {

    TokenDto register(RegisterCmd cmd);

    TokenDto register(RegisterWithAuthorizeCmd cmd);

    TokenDto register(RegisterWithAVCmd cmd);

    TokenDto register(RegisterWithVerifyCmd cmd);

    Boolean registerAndSendActivateCode(RegisterCmd cmd);

    Boolean registerAndSendActivateCode(RegisterWithAuthorizeCmd cmd);

    Boolean sendRegisterVerificationCode(SendVerificationCodeCmd cmd);

    AuthorizationCodeDto generateAuthorizationCode(GenerateAuthorizationCodeCmd cmd);

    Boolean sendActivateCode(SendActivateCodeCmd cmd);

    Boolean activate(ActivateCmd cmd);

    TokenDto login(LoginCmd cmd);

    TokenDto loginAfterActivate(LoginCmd cmd);

    Boolean sendLoginVerificationCode(SendVerificationCodeCmd cmd);

}
