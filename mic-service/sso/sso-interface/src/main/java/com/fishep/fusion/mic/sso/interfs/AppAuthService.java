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
 * @Date 2025/2/5 17:10
 * @Desc
 **/
public interface AppAuthService {

    RegisterRes register(RegisterReq req);

    LoginRes login(LoginReq req);

    SendVerificationCodeRes sendVerificationCode(SendVerificationCodeReq req);

    ActivateRes activate(ActivateReq req);

}
