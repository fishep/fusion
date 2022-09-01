package com.fishep.fusion.user.infra.converter;

import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.infra.model.UserDO;

public interface UserBuilder {
    UserDO toDO(User user);

    UserDO toDO(User user, UserDO userDO);

    User toEntity(UserDO userDO);

    User toEntity(UserDO userDO, User user);
}
