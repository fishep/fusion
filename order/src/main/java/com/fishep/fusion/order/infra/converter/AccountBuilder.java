package com.fishep.fusion.order.infra.converter;

import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.infra.feign.response.AccountResponse;

public interface AccountBuilder {

    Account toAccount(AccountResponse response);

    Account toAccount(com.fishep.fusion.common.rpc.response.AccountResponse response);

}
