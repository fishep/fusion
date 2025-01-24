package com.fishep.fusion.mic.sso.interfs.rpc.service.auth.impl;

import com.fishep.fusion.mic.sso.interfs.req.auth.ActivateReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.LoginReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendVerificationCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.ActivateRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendVerificationCodeRes;

/**
 * @Author fly.fei
 * @Date 2025/1/23 11:10
 * @Desc 商城认证管理员
 **/
public class MallAdminService extends AbstractAppUserService {

    @Override
    public RegisterRes register(RegisterReq req) {
        return null;
    }

    @Override
    public LoginRes login(LoginReq req) {
        return null;
    }

    @Override
    public SendVerificationCodeRes sendVerificationCode(SendVerificationCodeReq req) {
        return null;
    }

    @Override
    public ActivateRes activate(ActivateReq req) {
        return null;
    }

}
