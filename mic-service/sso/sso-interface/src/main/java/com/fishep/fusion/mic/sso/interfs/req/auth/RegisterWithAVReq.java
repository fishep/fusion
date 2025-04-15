package com.fishep.fusion.mic.sso.interfs.req.auth;

import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/3/22 10:57
 * @Desc 注册请求，验证请求是否授权，验证标识的有效性
 **/
@Data
public class RegisterWithAVReq {

    public String identifier;

    public String password;

    public String verificationCode;

    public String authorizationCode;

}
