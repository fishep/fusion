package com.fishep.fusion.user.application.assembler;

import com.fishep.fusion.user.application.dto.AccountDTO;
import com.fishep.fusion.user.domain.entity.Account;

public interface AccountAssembler {

    AccountDTO toAccountDTO(Account account);

}
