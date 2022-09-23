package com.fishep.fusion.order.domain.repository;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.order.domain.entity.Account;

public interface AccountRepository {

    Account find(AccountId accountId);

    Boolean save(Account account);

}
