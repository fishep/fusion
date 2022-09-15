package com.fishep.fusion.user.domain.service.impl;

import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.extend.HashService;
import com.fishep.fusion.user.domain.repository.UserRepository;
import com.fishep.fusion.user.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean register(User user) {
        userRepository.isNotExist(user);

        userRepository.save(user);

        userRepository.refresh(user);

        return Boolean.TRUE;
    }

    @Override
    public Boolean authentication(User user, String password, HashService hashService) {
        String hash = hashService.hash(password);

        return hash.equals(user.getPasswordHash());
    }
}
