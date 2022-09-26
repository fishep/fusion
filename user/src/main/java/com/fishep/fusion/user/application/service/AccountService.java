package com.fishep.fusion.user.application.service;

import com.fishep.fusion.user.application.cqe.AccountQueryCommand;
import com.fishep.fusion.user.application.dto.AccountDTO;

import javax.validation.Valid;

public interface AccountService {

    AccountDTO query(@Valid AccountQueryCommand command);

}
