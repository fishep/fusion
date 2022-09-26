package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public Account find(AccountId accountId) {
        return null;
    }

    @Override
    public Boolean save(Account account) {
        return null;
    }
}
