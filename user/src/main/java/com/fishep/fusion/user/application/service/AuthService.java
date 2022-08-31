package com.fishep.fusion.user.application.service;

import com.fishep.fusion.user.application.dto.UserDTO;

public interface AuthService {

    UserDTO register(String name, String email, String password);

}
