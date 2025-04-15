package com.fishep.fusion.mic.sso.interfs.webflux.controller.api.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.LoginReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;
import com.fishep.fusion.mic.sso.interfs.service.auth.AuthBackAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author fly.fei
 * @Date 2025/3/27 17:56
 * @Desc
 **/
@Slf4j
@RestController
@RequestMapping("/auth/back/admin")
public class AuthBackAdminController {

//    需要改成响应式接口
    @Autowired
    private AuthBackAdminService authBackAdminService;

    @PostMapping("/login")
    public Mono<LoginRes> login(@Validated @RequestBody LoginReq req) {
        return Mono.create(sink -> {
            sink.success(authBackAdminService.login(req));
        });
    }

}
