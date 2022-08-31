package com.fishep.fusion.user.infra.converter.impl;

import com.fishep.fusion.common.type.Email;
import com.fishep.fusion.user.common.type.UserId;
import com.fishep.fusion.user.common.type.UserName;
import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.infra.converter.UserBuilder;
import com.fishep.fusion.user.infra.model.UserDO;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserBuilderImpl implements UserBuilder {
    @Override
    public UserDO toDO(User user) {

        UserDO userDO = new UserDO();
        userDO.setId(user.getId().getValue());
        userDO.setName(user.getName().getValue());
        userDO.setEmail(user.getEmail().getValue());
        userDO.setPassword(user.getPasswordHash());
        userDO.setCreatedAt(user.getCreatedAt().getEpochSecond());
        userDO.setUpdatedAt(user.getUpdatedAt().getEpochSecond());

        return userDO;
    }

    @Override
    public User toEntity(UserDO userDO) {
        User user = new User();

        return this.toEntity(userDO, user);
    }

    @Override
    public User toEntity(UserDO userDO, User user) {
        user.setId(new UserId(userDO.getId()));
        user.setName(new UserName(userDO.getName()));
        user.setEmail(new Email(userDO.getEmail()));
        user.setPasswordHash(userDO.getPassword());
        user.setCreatedAt(Instant.ofEpochSecond(userDO.getCreatedAt()));
        user.setUpdatedAt(Instant.ofEpochSecond(userDO.getUpdatedAt()));

        return user;
    }
}
