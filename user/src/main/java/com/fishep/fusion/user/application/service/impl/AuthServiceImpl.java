package com.fishep.fusion.user.application.service.impl;

import com.fishep.fusion.user.application.assembler.UserAssembler;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.service.AuthService;
import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.message.RegisterSuccess;
import com.fishep.fusion.user.domain.producer.UserMessageProducer;
import com.fishep.fusion.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMessageProducer userMessageProducer;

    @Autowired
    private UserAssembler userAssembler;

    @Override
    public UserDTO register(String name, String email, String password) {

        User user = userAssembler.toEntity(name, email, password);

        userRepository.isNotExist(user);

        userRepository.save(user);

        userRepository.refresh(user);

        userMessageProducer.send(new RegisterSuccess());

        UserDTO userDTO = userAssembler.toDTO(user);

        return userDTO;
    }
}
