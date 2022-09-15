package com.fishep.fusion.user.domain.service;

import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.extend.HashService;

public interface UserService {

    Boolean register(User user);

    Boolean authentication(User user, String password, HashService hashService);

}
