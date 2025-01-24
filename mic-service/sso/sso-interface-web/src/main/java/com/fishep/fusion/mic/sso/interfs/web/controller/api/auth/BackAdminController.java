package com.fishep.fusion.mic.sso.interfs.web.controller.api.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2025/1/23 12:12
 * @Desc
 **/
@RestController
@RequestMapping("/auth/back/admin")
public class BackAdminController extends AppUserController {

    @PostMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/sendVerificationCode")
    public String sendVerificationCode() {
        return "sendVerificationCode";
    }

    @PostMapping("/activate")
    public String activate() {
        return "activate";
    }

}
