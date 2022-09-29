package com.fishep.fusion.user.infra.dao.impl;

import com.fishep.fusion.user.infra.dao.AccountDao;
import com.fishep.fusion.user.infra.mapper.AccountMapper;
import com.fishep.fusion.user.infra.model.AccountDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoMybatisImpl implements AccountDao {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public AccountDO select(Long id) {
        return accountMapper.select(id);
    }

    @Override
    public Boolean insert(AccountDO accountDO) {
        return accountMapper.insert(accountDO);
    }

    @Override
    public Boolean update(AccountDO accountDO) {
        return accountMapper.update(accountDO);
    }
}
