package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.repository.AccountRepository;
import com.fishep.fusion.order.infra.converter.AccountConverter;
import com.fishep.fusion.order.infra.feign.AccountFeign;
import com.fishep.fusion.order.infra.feign.request.AccountUpdateRequest;
import com.fishep.fusion.order.infra.feign.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    AccountFeign accountFeign;

    @Autowired
    AccountConverter accountConverter;

    @Override
    public Account find(AccountId accountId) {

        Result<AccountResponse> ret = accountFeign.one(accountId.getValue());

        if (ret.getCode() != 200){
            throw new RuntimeException(ret.getMessage());
        }

        AccountResponse data = ret.getData();

        Account account = accountConverter.toAccount(data);

        return account;
    }

    @Override
    public Boolean save(Account account) {

        AccountUpdateRequest request = new AccountUpdateRequest();
        request.setCurrency(account.getAmount().getCurrency().getCodeName());
        request.setAmount(account.getAmount().getValue());

        Result<Boolean> ret = accountFeign.save(account.getId().getValue(), request);

        if (ret.getCode() != 200 || !ret.getData()){
            throw new RuntimeException(ret.getMessage());
        }

        return Boolean.TRUE;
    }
}
