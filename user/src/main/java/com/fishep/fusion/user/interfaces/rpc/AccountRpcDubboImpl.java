package com.fishep.fusion.user.interfaces.rpc;

import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.rpc.AccountRpc;
import com.fishep.fusion.common.rpc.request.AccountUpdateRequest;
import com.fishep.fusion.common.rpc.response.AccountResponse;
import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.user.application.cqe.AccountQueryCommand;
import com.fishep.fusion.user.application.cqe.AccountUpdateCommand;
import com.fishep.fusion.user.application.dto.AccountDTO;
import com.fishep.fusion.user.application.service.AccountService;
import com.fishep.fusion.user.interfaces.converter.AccountConverter;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class AccountRpcDubboImpl implements AccountRpc {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountConverter accountConverter;

    @Override
    public Result<AccountResponse> one(Long id) {

        AccountQueryCommand command = new AccountQueryCommand(id);

        AccountDTO accountDTO = accountService.query(command);

        AccountResponse accountResponse = accountConverter.toRpcAccountResponse(accountDTO);

        return new Result<>(200, "account info", accountResponse);
    }

    @Override
    public Result<Boolean> save(Long id, AccountUpdateRequest request) {

        AccountUpdateCommand command = new AccountUpdateCommand(new AccountId(id), new Money(request.getCurrency(), request.getAmount()));

        accountService.updateAmount(command);

        return new Result<>(200, "update amount success!", Boolean.TRUE);
    }
}
