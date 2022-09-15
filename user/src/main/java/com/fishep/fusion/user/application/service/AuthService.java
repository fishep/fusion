package com.fishep.fusion.user.application.service;

import com.fishep.fusion.user.application.cqe.UserEmailLoginCommand;
import com.fishep.fusion.user.application.cqe.UserNameLoginCommand;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.dto.UserTokenDTO;

import javax.validation.Valid;

public interface AuthService {

    UserDTO register(String name, String email, String password);

    UserTokenDTO login(@Valid UserNameLoginCommand loginCommand);

    UserTokenDTO login(@Valid UserEmailLoginCommand loginCommand);

}
