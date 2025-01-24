package com.fishep.fusion.mic.sso.interfs;

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
 * @Date 2025/1/23 10:50
 * @Desc
 **/
public interface AuthAppUserService {

    RegisterRes register(RegisterReq req);

    LoginRes login(LoginReq req);

    SendVerificationCodeRes sendVerificationCode(SendVerificationCodeReq req);

    ActivateRes activate(ActivateReq req);

}
