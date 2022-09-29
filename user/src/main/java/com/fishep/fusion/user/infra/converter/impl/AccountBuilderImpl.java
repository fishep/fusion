package com.fishep.fusion.user.infra.converter.impl;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.AccountNumber;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.UserId;
import com.fishep.fusion.user.domain.entity.Account;
import com.fishep.fusion.user.infra.converter.AccountBuilder;
import com.fishep.fusion.user.infra.model.AccountDO;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AccountBuilderImpl implements AccountBuilder {

    @Override
    public Account toAccount(AccountDO accountDO) {

        Account account = new Account(new AccountId(accountDO.getId()),
                new AccountNumber(accountDO.getNumber()),
                new UserId(accountDO.getUserId()),
                accountDO.getName(),
                new Money(accountDO.getCurrency(), accountDO.getAmount()),
                new Money(accountDO.getCurrency(), accountDO.getQuota()),
                Instant.ofEpochSecond(accountDO.getCreatedAt()),
                Instant.ofEpochSecond(accountDO.getUpdatedAt())
        );

        return account;
    }

    @Override
    public AccountDO toAccountDO(Account account) {

        AccountDO accountDO = new AccountDO();
        accountDO.setId(account.getId().getValue());
        accountDO.setNumber(account.getNumber().getValue());
        accountDO.setUserId(account.getUserId().getValue());
        accountDO.setName(account.getName());
        accountDO.setCurrency(account.getAmount().getCurrency().getCodeName());
        accountDO.setAmount(account.getAmount().getValue());
        accountDO.setQuota(account.getQuota().getValue());
        accountDO.setCreatedAt(account.getCreatedAt().getEpochSecond());
        accountDO.setUpdatedAt(account.getUpdatedAt().getEpochSecond());

        return accountDO;
    }
}
