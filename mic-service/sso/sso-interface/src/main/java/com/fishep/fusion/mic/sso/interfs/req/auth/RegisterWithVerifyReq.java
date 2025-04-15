package com.fishep.fusion.mic.sso.interfs.req.auth;

/**
 * @Author fly.fei
 * @Date 2025/3/21 15:00
 * @Desc 注册请求，验证标识的有效性
 **/
public class RegisterWithVerifyReq {

    public String identifier;

    public String password;

    public String verificationCode;

}
