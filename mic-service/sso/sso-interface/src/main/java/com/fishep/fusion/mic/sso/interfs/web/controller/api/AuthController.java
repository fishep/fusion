package com.fishep.fusion.mic.sso.interfs.web.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fly.fei
 * @Date 2025/1/7 15:59
 * @Desc
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register() {


        return "hello world!";
    }

}
