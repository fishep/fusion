package com.fishep.fusion.mic.sso.interfs.service.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.GenerateAuthorizationCodeReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterWithAuthorizeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.GenerateAuthorizationCodeRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;

/**
 * @Author fly.fei
 * @Date 2025/3/26 16:55
 * @Desc 注册服务，将用户标识和密码注册到系统，需要授权之后才能注册
 * 典型的过程如下，管理员生成一个授权码，然后将授权码发送给别人，别人通过授权码来注册
 **/
public interface RegisterWithAuthorizeService {

    RegisterRes register(RegisterWithAuthorizeReq req);

    GenerateAuthorizationCodeRes generateAuthorizationCode(GenerateAuthorizationCodeReq req);

}
