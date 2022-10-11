package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.rpc.AccountRpc;
import com.fishep.fusion.common.rpc.request.AccountUpdateRequest;
import com.fishep.fusion.common.rpc.response.AccountResponse;
import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.repository.AccountRepository;
import com.fishep.fusion.order.infra.converter.AccountBuilder;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class AccountRepositoryDubboImpl implements AccountRepository {

    @DubboReference
    AccountRpc accountRpc;

    @Autowired
    AccountBuilder accountBuilder;

    @Override
    public Account find(AccountId accountId) {

        Result<AccountResponse> ret = accountRpc.one(accountId.getValue());

        if (ret.getCode() != 200) {
            throw new RuntimeException(ret.getMessage());
        }

        AccountResponse data = ret.getData();

        Account account = accountBuilder.toAccount(data);

        return account;
    }

    @Override
    public Boolean save(Account account) {

        AccountUpdateRequest request = new AccountUpdateRequest();
        request.setCurrency(account.getAmount().getCurrency().getCodeName());
        request.setAmount(account.getAmount().getValue());

        Result<Boolean> ret = accountRpc.save(account.getId().getValue(), request);

        if (ret.getCode() != 200 || !ret.getData()) {
            throw new RuntimeException(ret.getMessage());
        }

        return Boolean.TRUE;
    }
}
