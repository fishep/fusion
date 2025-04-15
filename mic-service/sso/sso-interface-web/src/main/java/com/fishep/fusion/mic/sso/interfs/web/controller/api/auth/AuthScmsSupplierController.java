package com.fishep.fusion.mic.sso.interfs.web.controller.api.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.GenerateAuthorizationCodeReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.LoginReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterWithAVReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendVerificationCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.GenerateAuthorizationCodeRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendVerificationCodeRes;
import com.fishep.fusion.mic.sso.interfs.service.auth.AuthScmsSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2025/3/27 18:09
 * @Desc
 **/
@RestController
@RequestMapping("/auth/scms/supplier")
public class AuthScmsSupplierController {

    @Autowired
    private AuthScmsSupplierService authScmsSupplierService;

    @PostMapping("/login")
    public LoginRes login(@Validated @RequestBody LoginReq req) {
        return authScmsSupplierService.login(req);
    }

    @PostMapping("/sendLoginVerificationCode")
    public SendVerificationCodeRes sendLoginVerificationCode(@Validated @RequestBody SendVerificationCodeReq req) {
        return authScmsSupplierService.sendLoginVerificationCode(req);
    }

    @PostMapping("/register")
    public RegisterRes register(@Validated @RequestBody RegisterWithAVReq req) {
        return authScmsSupplierService.register(req);
    }

    @PostMapping("/generateAuthorizationCode")
    public GenerateAuthorizationCodeRes generateAuthorizationCode(@Validated @RequestBody GenerateAuthorizationCodeReq req) {
        return authScmsSupplierService.generateAuthorizationCode(req);
    }

    @PostMapping("/sendRegisterVerificationCode")
    public SendVerificationCodeRes sendRegisterVerificationCode(@Validated @RequestBody SendVerificationCodeReq req) {
        return authScmsSupplierService.sendRegisterVerificationCode(req);
    }
}
