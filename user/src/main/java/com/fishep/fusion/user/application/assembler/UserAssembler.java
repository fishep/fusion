package com.fishep.fusion.user.application.assembler;

import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.dto.UserTokenDTO;
import com.fishep.fusion.user.domain.entity.User;

public interface UserAssembler {

    UserDTO toDTO(User user);

    UserTokenDTO toUserTokenDTO(User user, String token);

    UserTokenDTO toUserTokenDTO(UserTokenDTO userTokenDTO, User user, String token);

//    User toEntity(UserDTO userDTO);

    User toEntity(String name, String email, String password);

}
