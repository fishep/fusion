package com.fishep.fusion.user.application.assembler.impl;

import com.fishep.fusion.common.type.Email;
import com.fishep.fusion.user.application.assembler.UserAssembler;
import com.fishep.fusion.user.application.dto.TokenDTO;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.dto.UserTokenDTO;
import com.fishep.fusion.common.type.UserId;
import com.fishep.fusion.common.type.UserName;
import com.fishep.fusion.common.type.UserPassword;
import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.extend.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserAssemblerImpl implements UserAssembler {

    @Autowired
    private HashService hashService;

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId().getValue());
        userDTO.setName(user.getName().getValue());
        userDTO.setEmail(user.getEmail().getValue());
        userDTO.setCreatedAt(user.getCreatedAt().getEpochSecond());
        userDTO.setUpdatedAt(user.getUpdatedAt().getEpochSecond());
        return userDTO;
    }

    @Override
    public UserTokenDTO toUserTokenDTO(User user, TokenDTO tokenDTO) {
        return this.toUserTokenDTO(new UserTokenDTO(), user, tokenDTO);
    }

    @Override
    public UserTokenDTO toUserTokenDTO(UserTokenDTO userTokenDTO, User user, TokenDTO tokenDTO) {
        userTokenDTO.setUserDTO(this.toDTO(user));
        userTokenDTO.setTokenDTO(tokenDTO);

        return userTokenDTO;
    }

    @Override
    public User toEntity(String name, String email, String password) {
        User user = new User();
        user.setId(new UserId());
        user.setName(new UserName(name));
        user.setEmail(new Email(email));
        user.setPasswordHash(hashService.hash(new UserPassword(password).getValue()));
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());

        return user;
    }
}
