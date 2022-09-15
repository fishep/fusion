package com.fishep.fusion.user.interfaces.converter.impl;

import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.dto.UserTokenDTO;
import com.fishep.fusion.user.interfaces.converter.UserConverter;
import com.fishep.fusion.user.interfaces.response.UserLoginResponse;
import com.fishep.fusion.user.interfaces.response.UserRegisterResponse;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserRegisterResponse toVO(UserDTO userDTO) {

        UserRegisterResponse response = new UserRegisterResponse();
        response.setId(userDTO.getId());
        response.setName(userDTO.getName());
        response.setEmail(userDTO.getEmail());
        response.setCreatedAt(Instant.ofEpochSecond(userDTO.getCreatedAt()).toString());
        response.setUpdatedAt(Instant.ofEpochSecond(userDTO.getUpdatedAt()).toString());

        return response;
    }

    @Override
    public UserLoginResponse toVO(UserTokenDTO userTokenDTO) {

        UserLoginResponse response = new UserLoginResponse();
        response.setId(userTokenDTO.getUserDTO().getId());
        response.setName(userTokenDTO.getUserDTO().getName());
        response.setEmail(userTokenDTO.getUserDTO().getEmail());
        response.setCreatedAt(Instant.ofEpochSecond(userTokenDTO.getUserDTO().getCreatedAt()).toString());
        response.setUpdatedAt(Instant.ofEpochSecond(userTokenDTO.getUserDTO().getUpdatedAt()).toString());
        response.setToken(userTokenDTO.getToken());

        return response;
    }
}
