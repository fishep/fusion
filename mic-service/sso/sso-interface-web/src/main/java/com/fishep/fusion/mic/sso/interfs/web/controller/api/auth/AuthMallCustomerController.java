package com.fishep.fusion.mic.sso.interfs.web.controller.api.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.LoginReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterWithVerifyReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendVerificationCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendVerificationCodeRes;
import com.fishep.fusion.mic.sso.interfs.service.auth.AuthMallCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2025/3/27 18:04
 * @Desc
 **/
@RestController
@RequestMapping("/auth/mall/customer")
public class AuthMallCustomerController {

    @Autowired
    private AuthMallCustomerService authMallCustomerService;

    @PostMapping("/login")
    public LoginRes login(@Validated @RequestBody LoginReq req) {
        return authMallCustomerService.login(req);
    }

    @PostMapping("/sendLoginVerificationCode")
    public SendVerificationCodeRes sendLoginVerificationCode(@Validated @RequestBody SendVerificationCodeReq req) {
        return authMallCustomerService.sendLoginVerificationCode(req);
    }

    @PostMapping("/register")
    public RegisterRes register(@Validated @RequestBody RegisterWithVerifyReq req) {
        return authMallCustomerService.register(req);
    }

    @PostMapping("/sendRegisterVerificationCode")
    public SendVerificationCodeRes sendRegisterVerificationCode(@Validated @RequestBody SendVerificationCodeReq req) {
        return authMallCustomerService.sendRegisterVerificationCode(req);
    }
}
