package com.fishep.fusion.user.domain.repository;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.user.domain.entity.Account;

public interface AccountRepository {

    Account find(AccountId id);

}
