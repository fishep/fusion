package com.fishep.fusion.user.application.service.impl;

import com.fishep.fusion.common.type.UserId;
import com.fishep.fusion.user.application.assembler.UserAssembler;
import com.fishep.fusion.user.application.cqe.UserQueryCommand;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.service.UserCase;
import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCaseImpl implements UserCase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAssembler userAssembler;

    @Override
    public UserDTO query(UserQueryCommand command) {

        UserId userId = new UserId(command.getId());

        User user = userRepository.find(userId);

        UserDTO userDTO = userAssembler.toDTO(user);

        return userDTO;
    }
}
