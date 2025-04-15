package com.fishep.fusion.mic.sso.interfs.req.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * @Author fly.fei
 * @Date 2025/1/20 17:07
 * @Desc 激活请求
 **/
public class ActivateReq {

    @NotBlank
    public String identifier;

    public String activateCode;

}
