package com.fishep.fusion.mic.sso.interfs.req.auth;

/**
 * @Author fly.fei
 * @Date 2025/3/22 10:40
 * @Desc 注册请求，验证请求是否授权
 **/
public class RegisterWithAuthorizeReq {

    public String identifier;

    public String password;

    public String authorizationCode;

}
