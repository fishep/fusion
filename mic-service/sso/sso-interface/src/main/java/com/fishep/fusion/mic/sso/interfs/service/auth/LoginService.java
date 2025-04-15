package com.fishep.fusion.mic.sso.interfs.service.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.LoginReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendVerificationCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendVerificationCodeRes;

/**
 * @Author fly.fei
 * @Date 2025/3/26 17:01
 * @Desc 登录服务，用户根据标识和凭证登录
 * 标识可以是：用户名，邮箱，电话号码，等等
 * 凭证可以是：密码，验证码，等等
 **/
public interface LoginService {

    LoginRes login(LoginReq req);

    SendVerificationCodeRes sendLoginVerificationCode(SendVerificationCodeReq req);

}
