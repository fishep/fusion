package com.fishep.fusion.user.infra.dao.impl;

import com.fishep.fusion.user.infra.dao.UserDao;
import com.fishep.fusion.user.infra.mapper.UserMapper;
import com.fishep.fusion.user.infra.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoMybatisImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean insert(UserDO user) {
        Boolean flag = userMapper.insert(user);

        return flag;
    }

    @Override
    public Boolean delete(UserDO user) {
        Boolean flag = userMapper.delete(user);

        return flag;
    }

    @Override
    public Boolean delete(Long id) {
        Boolean flag = userMapper.deleteById(id);

        return flag;
    }

    @Override
    public Boolean update(UserDO user) {
        Boolean flag = userMapper.update(user);

        return flag;
    }

    @Override
    public UserDO select(Long id) {
        UserDO userDO = userMapper.select(id);

        return userDO;
    }

    @Override
    public UserDO select(UserDO user) {
        if (user.getId() != null){
            return userMapper.select(user.getId());
        }
        if (user.getName() != null){
            return userMapper.selectByName(user.getName());
        }
        if (user.getEmail() != null){
            return userMapper.selectByEmail(user.getEmail());
        }

        return null;
    }

    @Override
    public UserDO selectByName(String name) {
        UserDO userDO = userMapper.selectByName(name);

        return userDO;
    }

    @Override
    public UserDO selectByEmail(String email) {
        UserDO userDO = userMapper.selectByEmail(email);

        return userDO;
    }

    @Override
    public Boolean isExist(UserDO user) {
        Boolean flag = Boolean.FALSE;

        if (this.select(user) != null){
            flag = Boolean.TRUE;
        }

        return flag;
    }
}
