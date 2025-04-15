package com.fishep.fusion.mic.sso.interfs.web.controller.api.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.GenerateAuthorizationCodeReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.LoginReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterWithAVReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendVerificationCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.GenerateAuthorizationCodeRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendVerificationCodeRes;
import com.fishep.fusion.mic.sso.interfs.service.auth.AuthBackAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2025/3/27 17:56
 * @Desc
 **/
@RestController
@RequestMapping("/auth/back/admin")
public class AuthBackAdminController {

    @Autowired
    private AuthBackAdminService authBackAdminService;

    @PostMapping("/login")
    public LoginRes login(@Validated @RequestBody LoginReq req) {
        return authBackAdminService.login(req);
    }

    @PostMapping("/sendLoginVerificationCode")
    public SendVerificationCodeRes sendLoginVerificationCode(@Validated @RequestBody SendVerificationCodeReq req) {
        return authBackAdminService.sendLoginVerificationCode(req);
    }

    @PostMapping("/register")
    public RegisterRes register(@Validated @RequestBody RegisterWithAVReq req) {
        return authBackAdminService.register(req);
    }

    @PostMapping("/generateAuthorizationCode")
    public GenerateAuthorizationCodeRes generateAuthorizationCode(@Validated @RequestBody GenerateAuthorizationCodeReq req) {
        return authBackAdminService.generateAuthorizationCode(req);
    }

    @PostMapping("/sendRegisterVerificationCode")
    public SendVerificationCodeRes sendRegisterVerificationCode(@Validated @RequestBody SendVerificationCodeReq req) {
        return authBackAdminService.sendRegisterVerificationCode(req);
    }
}
