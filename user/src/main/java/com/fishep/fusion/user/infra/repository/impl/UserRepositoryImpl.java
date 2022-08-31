package com.fishep.fusion.user.infra.repository.impl;

import com.fishep.fusion.common.type.Email;
import com.fishep.fusion.user.common.type.UserId;
import com.fishep.fusion.user.common.type.UserName;
import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.repository.UserRepository;
import com.fishep.fusion.user.infra.converter.UserBuilder;
import com.fishep.fusion.user.infra.dao.UserDao;
import com.fishep.fusion.user.infra.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserDao userDao;

    @Autowired
    UserBuilder userBuilder;

    @Override
    public User find(UserId id) {
        UserDO userDO = userDao.select(id.getValue());
        if (userDO == null) {
            throw new RuntimeException("未查到用户, " + id);
        }

        User user = userBuilder.toEntity(userDO);

        return user;
    }

    @Override
    public User find(UserName name) {
        UserDO userDO = userDao.selectByName(name.getValue());
        if (userDO == null) {
            throw new RuntimeException("未查到用户, " + name);
        }

        User user = userBuilder.toEntity(userDO);

        return user;
    }

    @Override
    public User find(Email email) {
        UserDO userDO = userDao.selectByEmail(email.getValue());
        if (userDO == null) {
            throw new RuntimeException("未查到用户, " + email);
        }

        User user = userBuilder.toEntity(userDO);

        return user;
    }

    @Override
    public User findByAny(UserName name, Email email) {
        UserDO userDO = userDao.selectByName(name.getValue());
        if (userDO == null) {
            userDO = userDao.selectByEmail(email.getValue());
        }

        if (userDO == null) {
            throw new RuntimeException("未查到用户, " + name + " or " + email);
        }

        User user = userBuilder.toEntity(userDO);

        return user;
    }

    @Override
    public User refresh(User user) {

        UserDO userDO = userBuilder.toDO(user);

        UserDO newUserDO = userDao.select(userDO);

        if (newUserDO == null) {
            throw new RuntimeException("用户刷新失败, " + user);
        }

        return userBuilder.toEntity(newUserDO, user);
    }

    @Override
    public Boolean save(User user) {

        UserDO userDO = userBuilder.toDO(user);

        Boolean isExist = userDao.isExist(userDO);

        if (isExist) {
            if (!userDao.update(userDO)) {
                throw new RuntimeException("用户保存更新失败, " + user);
            }
        } else {
            if (!userDao.insert(userDO)) {
                throw new RuntimeException("用户保存新增失败, " + user);
            }
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean isExist(User user) {

        UserDO userDO = userBuilder.toDO(user);

        Boolean flag = userDao.isExist(userDO);

        if (!flag) {
            throw new RuntimeException("用户不存在, " + user);
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean isNotExist(User user) {

        UserDO userDO = userBuilder.toDO(user);

        Boolean flag = userDao.isExist(userDO);

        if (flag) {
            throw new RuntimeException("用户已存在, " + user);
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean remove(User user) {
        UserDO userDO = userBuilder.toDO(user);

        Boolean flag = userDao.delete(userDO);

        return flag;
    }
}
