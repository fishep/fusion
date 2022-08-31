package com.fishep.fusion.user.interfaces.converter;

import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.interfaces.response.UserRegisterResponse;

public interface UserConverter {

    UserRegisterResponse toVO(UserDTO userDTO);

}
