package com.fishep.fusion.common.rpc;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.rpc.request.AccountUpdateRequest;
import com.fishep.fusion.common.rpc.response.AccountResponse;

public interface AccountRpc {

    Result<AccountResponse> one(Long id);

    Result<Boolean> save(Long id, AccountUpdateRequest request);

}
