package com.fishep.fusion.user.application.service;

import com.fishep.fusion.user.application.cqe.UserQueryCommand;
import com.fishep.fusion.user.application.dto.UserDTO;

import javax.validation.Valid;

public interface UserCase {

    UserDTO query(@Valid UserQueryCommand command);

}
