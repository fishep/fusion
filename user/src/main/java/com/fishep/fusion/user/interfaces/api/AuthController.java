package com.fishep.fusion.user.interfaces.api;

import com.fishep.fusion.common.annotation.ResultHandler;
import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.type.Email;
import com.fishep.fusion.common.type.UserName;
import com.fishep.fusion.user.application.cqe.UserEmailLoginCommand;
import com.fishep.fusion.user.application.cqe.UserNameLoginCommand;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.dto.UserTokenDTO;
import com.fishep.fusion.user.application.service.AuthService;
import com.fishep.fusion.user.interfaces.converter.UserConverter;
import com.fishep.fusion.user.interfaces.request.UserLoginRequest;
import com.fishep.fusion.user.interfaces.request.UserRegisterRequest;
import com.fishep.fusion.user.interfaces.response.UserLoginResponse;
import com.fishep.fusion.user.interfaces.response.UserRegisterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/user/auth")
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

    @ResultHandler
    @PostMapping("/login")
    public Result<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        UserTokenDTO userTokenDTO;

        switch (request.determineNameOrEmail()) {
            case "email":
                Email email = new Email(request.getIdentify());
                UserEmailLoginCommand emailLoginCommand = new UserEmailLoginCommand();
                emailLoginCommand.setUserEmail(email);
                emailLoginCommand.setPassword(request.getPassword());

                userTokenDTO = authService.login(emailLoginCommand);
                break;
            case "name":
                UserName userName = new UserName(request.getIdentify());
                UserNameLoginCommand nameLoginCommand = new UserNameLoginCommand();
                nameLoginCommand.setUserName(userName);
                nameLoginCommand.setPassword(request.getPassword());

                userTokenDTO = authService.login(nameLoginCommand);
                break;
            default:
                throw new RuntimeException("email or name pattern error");
        }

        UserLoginResponse vo = userConverter.toVO(userTokenDTO);

        return new Result<>(200, "user login success!", vo);
    }

    @ResultHandler
    @GetMapping("/gateway/header")
//    public Result<String> login(HttpServletRequest request)
    public Result<String> login(@RequestHeader("Fusion-User-Id") String userId, @RequestHeader("Fusion-User-Name") String userName) {
        return new Result<>(200, "user are logged, gateway header info", "userId: " + userId + ", userName: " + userName);
    }
}
