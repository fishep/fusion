package com.fishep.fusion.user.domain.service.impl;

import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.repository.UserRepository;
import com.fishep.fusion.user.domain.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean register(User user) {

        userRepository.isNotExist(user);

        userRepository.save(user);

        userRepository.refresh(user);

        return Boolean.TRUE;
    }
}
