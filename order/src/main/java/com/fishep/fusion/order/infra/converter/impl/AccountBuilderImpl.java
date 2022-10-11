package com.fishep.fusion.order.infra.converter.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.infra.converter.AccountBuilder;
import com.fishep.fusion.order.infra.feign.response.AccountResponse;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AccountBuilderImpl implements AccountBuilder {

    @Override
    public Account toAccount(AccountResponse response) {

        AccountId accountId = new AccountId(response.getId());
        Money amount = new Money(response.getCurrency(), response.getAmount());
        Instant createAt = DateUtil.parse(response.getCreatedAt(), DatePattern.UTC_PATTERN).toInstant();
        Instant updateAt = DateUtil.parse(response.getUpdatedAt(), DatePattern.UTC_PATTERN).toInstant();

        Account account = new Account(accountId, amount, createAt, updateAt);

        return account;
    }

    @Override
    public Account toAccount(com.fishep.fusion.common.rpc.response.AccountResponse response) {

        AccountId accountId = new AccountId(response.getId());
        Money amount = new Money(response.getCurrency(), response.getAmount());
        Instant createAt = DateUtil.parse(response.getCreatedAt(), DatePattern.UTC_PATTERN).toInstant();
        Instant updateAt = DateUtil.parse(response.getUpdatedAt(), DatePattern.UTC_PATTERN).toInstant();

        Account account = new Account(accountId, amount, createAt, updateAt);

        return account;
    }
}
