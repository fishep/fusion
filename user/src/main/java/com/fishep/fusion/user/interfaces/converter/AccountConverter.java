package com.fishep.fusion.user.interfaces.converter;

import com.fishep.fusion.user.application.dto.AccountDTO;
import com.fishep.fusion.user.interfaces.response.AccountResponse;

public interface AccountConverter {

    AccountResponse toAccountResponse(AccountDTO accountDTO);

    com.fishep.fusion.common.rpc.response.AccountResponse toRpcAccountResponse(AccountDTO accountDTO);

}
