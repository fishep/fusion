package com.fishep.fusion.user.application.assembler.impl;

import com.fishep.fusion.user.application.assembler.AccountAssembler;
import com.fishep.fusion.user.application.dto.AccountDTO;
import com.fishep.fusion.user.domain.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountAssemblerImpl implements AccountAssembler {

    @Override
    public AccountDTO toAccountDTO(Account account) {

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId().getValue());
        accountDTO.setNumber(account.getNumber().getValue());
        accountDTO.setUserId(account.getUserId().getValue());
        accountDTO.setName(account.getName());
        accountDTO.setCurrency(account.getAmount().getCurrency().getCodeName());
        accountDTO.setAmount(account.getAmount().getValue());
        accountDTO.setQuota(account.getQuota().getValue());
        accountDTO.setCreatedAt(account.getCreatedAt().getEpochSecond());
        accountDTO.setUpdatedAt(account.getUpdatedAt().getEpochSecond());

        return accountDTO;
    }
}
