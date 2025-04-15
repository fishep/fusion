package com.fishep.fusion.mic.sso.interfs.service.auth.impl;

import com.fishep.fusion.mic.sso.interfs.req.auth.LoginReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterWithVerifyReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendVerificationCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendVerificationCodeRes;
import com.fishep.fusion.mic.sso.interfs.service.auth.AuthMallCustomerService;
import org.springframework.stereotype.Component;

/**
 * @Author fly.fei
 * @Date 2025/3/27 17:50
 * @Desc
 **/
@Component
public class AuthMallCustomerServiceImpl implements AuthMallCustomerService {
    @Override
    public LoginRes login(LoginReq req) {
        return null;
    }

    @Override
    public SendVerificationCodeRes sendLoginVerificationCode(SendVerificationCodeReq req) {
        return null;
    }

    @Override
    public RegisterRes register(RegisterWithVerifyReq req) {
        return null;
    }

    @Override
    public SendVerificationCodeRes sendRegisterVerificationCode(SendVerificationCodeReq req) {
        return null;
    }
}
