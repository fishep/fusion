package com.fishep.fusion.user.infra.dao;

import com.fishep.fusion.user.infra.model.AccountDO;

public interface AccountDao {

    AccountDO select(Long id);

    Boolean insert(AccountDO accountDO);

    Boolean update(AccountDO accountDO);

}
