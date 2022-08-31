package com.fishep.fusion.user.infra.dao;

import com.fishep.fusion.user.infra.model.UserDO;

public interface UserDao {

    Boolean insert(UserDO user);

    Boolean delete(UserDO user);

    Boolean delete(Long id);

    Boolean update(UserDO user);

    UserDO select(UserDO user);

    UserDO select(Long id);

    UserDO selectByName(String name);

    UserDO selectByEmail(String email);

    Boolean isExist(UserDO user);
}
