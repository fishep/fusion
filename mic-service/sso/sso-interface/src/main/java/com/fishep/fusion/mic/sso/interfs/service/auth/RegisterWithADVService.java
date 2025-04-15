package com.fishep.fusion.mic.sso.interfs.service.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.ActivateReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.GenerateAuthorizationCodeReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterWithAuthorizeReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendActivateCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.ActivateRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.GenerateAuthorizationCodeRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendActivateCodeRes;

/**
 * @Author fly.fei
 * @Date 2025/3/26 18:11
 * @Desc 注册服务，将用户标识和密码注册到系统，需要授权之后才能注册，注册之后验证标识的有效性
 * 典型的过程如下，管理员生成一个授权码，然后将授权码发送给别人，别人通过授权码来注册
 * 用户注册之后发送验证码，用户使用验证码激活
 **/
public interface RegisterWithADVService {

    RegisterRes register(RegisterWithAuthorizeReq req);

    GenerateAuthorizationCodeRes generateAuthorizationCode(GenerateAuthorizationCodeReq req);

    SendActivateCodeRes sendActivateCode(SendActivateCodeReq req);

    ActivateRes activate(ActivateReq req);

}
