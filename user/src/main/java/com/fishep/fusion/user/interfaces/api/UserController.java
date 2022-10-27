package com.fishep.fusion.user.interfaces.api;

import com.fishep.fusion.common.annotation.ResultHandler;
import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.user.application.cqe.UserQueryCommand;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.service.UserCase;
import com.fishep.fusion.user.interfaces.converter.UserConverter;
import com.fishep.fusion.user.interfaces.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user/user")
public class UserController {

    @Autowired
    UserCase userCase;

    @Autowired
    UserConverter userConverter;

    @ResultHandler
    @GetMapping("/users/{id}")
    public Result<UserResponse> one(@PathVariable("id") Long id) {

        UserQueryCommand command = new UserQueryCommand(id);

        UserDTO userDTO = userCase.query(command);

        UserResponse data = userConverter.toUserResponse(userDTO);

        return new Result<>(200, "user info", data);
    }

}
