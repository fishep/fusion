package com.fishep.fusion.user.infra.converter;

import com.fishep.fusion.user.domain.entity.Account;
import com.fishep.fusion.user.infra.model.AccountDO;

public interface AccountBuilder {

    Account toAccount(AccountDO accountDO);

}
