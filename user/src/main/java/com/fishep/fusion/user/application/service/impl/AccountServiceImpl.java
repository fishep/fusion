package com.fishep.fusion.user.application.service.impl;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.user.application.assembler.AccountAssembler;
import com.fishep.fusion.user.application.cqe.AccountQueryCommand;
import com.fishep.fusion.user.application.dto.AccountDTO;
import com.fishep.fusion.user.application.service.AccountService;
import com.fishep.fusion.user.domain.entity.Account;
import com.fishep.fusion.user.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountAssembler accountAssembler;

    @Override
    public AccountDTO query(AccountQueryCommand command) {

        AccountId accountId = new AccountId(command.getId());

        Account account = accountRepository.find(accountId);

        AccountDTO accountDTO = accountAssembler.toAccountDTO(account);

        return accountDTO;
    }
}
