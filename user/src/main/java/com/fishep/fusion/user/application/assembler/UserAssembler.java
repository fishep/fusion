package com.fishep.fusion.user.application.assembler;

import com.fishep.fusion.user.application.dto.TokenDTO;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.dto.UserTokenDTO;
import com.fishep.fusion.user.domain.entity.User;

public interface UserAssembler {

    UserDTO toDTO(User user);

    UserTokenDTO toUserTokenDTO(User user, TokenDTO tokenDTO);

    UserTokenDTO toUserTokenDTO(UserTokenDTO userTokenDTO, User user, TokenDTO tokenDTO);

//    User toEntity(UserDTO userDTO);

    User toEntity(String name, String email, String password);

}
