package com.fishep.fusion.user.interfaces.api;

import com.fishep.fusion.common.annotation.ResultHandler;
import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.service.AuthService;
import com.fishep.fusion.user.interfaces.converter.UserConverter;
import com.fishep.fusion.user.interfaces.request.UserRegisterRequest;
import com.fishep.fusion.user.interfaces.response.UserRegisterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserConverter userConverter;

    @ResultHandler
    @PostMapping("/register")
    public Result<UserRegisterResponse> register(@RequestBody UserRegisterRequest request) {

        UserDTO userDTO = authService.register(request.getName(), request.getEmail(), request.getPassword());

        if (userDTO == null) {
            return new Result<>(400, "user register fail");
        }

        UserRegisterResponse vo = userConverter.toVO(userDTO);

        return new Result<>(201, "user register success!", vo);
    }
}
