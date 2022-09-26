package com.fishep.fusion.user.interfaces.converter.impl;

import com.fishep.fusion.user.application.dto.AccountDTO;
import com.fishep.fusion.user.interfaces.converter.AccountConverter;
import com.fishep.fusion.user.interfaces.response.AccountResponse;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AccountConverterImpl implements AccountConverter {

    @Override
    public AccountResponse toAccountResponse(AccountDTO accountDTO) {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(accountDTO.getId());
        accountResponse.setNumber(accountDTO.getNumber());
        accountResponse.setUserId(accountDTO.getUserId());
        accountResponse.setName(accountDTO.getName());
        accountResponse.setCurrency(accountDTO.getCurrency());
        accountResponse.setAmount(accountDTO.getAmount());
        accountResponse.setQuota(accountDTO.getQuota());
        accountResponse.setCreatedAt(Instant.ofEpochSecond(accountDTO.getCreatedAt()).toString());
        accountResponse.setUpdatedAt(Instant.ofEpochSecond(accountDTO.getUpdatedAt()).toString());

        return accountResponse;
    }
}
