package com.fishep.fusion.mic.sso.interfs.service.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterWithVerifyReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendVerificationCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendVerificationCodeRes;

/**
 * @Author fly.fei
 * @Date 2025/3/26 16:54
 * @Desc 注册服务，将用户标识和密码注册到系统，需要验证标识的有效性
 * 典型的过程如下，先发送验证码到用户的邮箱，用户获得验证码之后填入页面注册
 **/
public interface RegisterWithVerifyService {

    RegisterRes register(RegisterWithVerifyReq req);

    SendVerificationCodeRes sendRegisterVerificationCode(SendVerificationCodeReq req);

}
