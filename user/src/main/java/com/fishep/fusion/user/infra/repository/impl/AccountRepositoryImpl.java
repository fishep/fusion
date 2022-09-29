package com.fishep.fusion.user.infra.repository.impl;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.user.domain.entity.Account;
import com.fishep.fusion.user.domain.repository.AccountRepository;
import com.fishep.fusion.user.infra.converter.AccountBuilder;
import com.fishep.fusion.user.infra.dao.AccountDao;
import com.fishep.fusion.user.infra.model.AccountDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    AccountDao accountDao;

    @Autowired
    AccountBuilder accountBuilder;

    @Override
    public Account find(AccountId id) {

        AccountDO accountDO = accountDao.select(id.getValue());
        if (accountDO == null) {
            throw new RuntimeException("账户不存在, id: " + id);
        }

        Account account = accountBuilder.toAccount(accountDO);

        return account;
    }

    @Override
    public Boolean save(Account account) {

        AccountDO accountDO = accountBuilder.toAccountDO(account);

        AccountDO ret = accountDao.select(accountDO.getId());
        if (ret == null) {
            if (!accountDao.insert(accountDO)) {
                throw new RuntimeException("insert fail, " + account);
            }
        } else {
            if (!accountDao.update(accountDO)) {
                throw new RuntimeException("update fail, " + account);
            }
        }

        return Boolean.TRUE;
    }
}
