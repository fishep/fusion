package com.fishep.fusion.mic.sso.interfs.req.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/1/20 16:20
 * @Desc
 **/
@Data
public class LoginReq {

    @NotBlank
    public String identifier;

    @NotBlank
    public String certificate;

}
