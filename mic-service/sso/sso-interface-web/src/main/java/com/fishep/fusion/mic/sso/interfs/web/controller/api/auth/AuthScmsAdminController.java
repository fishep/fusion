package com.fishep.fusion.mic.sso.interfs.web.controller.api.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.LoginReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendVerificationCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendVerificationCodeRes;
import com.fishep.fusion.mic.sso.interfs.service.auth.AuthScmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2025/3/27 18:06
 * @Desc
 **/
@RestController
@RequestMapping("/auth/scms/admin")
public class AuthScmsAdminController {

    @Autowired
    private AuthScmsAdminService authScmsAdminService;

    @PostMapping("/login")
    public LoginRes login(@Validated @RequestBody LoginReq req) {
        return authScmsAdminService.login(req);
    }

    @PostMapping("/sendLoginVerificationCode")
    public SendVerificationCodeRes sendLoginVerificationCode(@Validated @RequestBody SendVerificationCodeReq req) {
        return authScmsAdminService.sendLoginVerificationCode(req);
    }
}
