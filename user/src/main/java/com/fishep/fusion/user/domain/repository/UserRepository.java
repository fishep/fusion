package com.fishep.fusion.user.domain.repository;

import com.fishep.fusion.common.type.Email;
import com.fishep.fusion.user.common.type.UserId;
import com.fishep.fusion.user.common.type.UserName;
import com.fishep.fusion.user.domain.entity.User;

public interface UserRepository {

    User find(UserId id);
    User find(UserName name);
    User find(Email email);
    User findByAny(UserName name, Email email);

    User refresh(User user);

    Boolean save(User user);

    Boolean isExist(User user);
    Boolean isNotExist(User user);

    Boolean remove(User user);
}
