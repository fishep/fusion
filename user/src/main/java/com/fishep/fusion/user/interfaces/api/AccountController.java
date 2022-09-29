package com.fishep.fusion.user.interfaces.api;

import com.fishep.fusion.common.annotation.ResultHandler;
import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.user.application.cqe.AccountQueryCommand;
import com.fishep.fusion.user.application.cqe.AccountUpdateCommand;
import com.fishep.fusion.user.application.dto.AccountDTO;
import com.fishep.fusion.user.application.service.AccountService;
import com.fishep.fusion.user.interfaces.converter.AccountConverter;
import com.fishep.fusion.user.interfaces.request.AccountUpdateRequest;
import com.fishep.fusion.user.interfaces.response.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountConverter accountConverter;

    @ResultHandler
    @GetMapping("/accounts/{id}")
    public Result<AccountResponse> one(@PathVariable("id") Long id) {

        AccountQueryCommand command = new AccountQueryCommand(id);

        AccountDTO accountDTO = accountService.query(command);

        AccountResponse accountResponse = accountConverter.toAccountResponse(accountDTO);

        return new Result<AccountResponse>(200, "account info", accountResponse);
    }

    @ResultHandler
    @PostMapping("/accounts/{id}")
    public Result<Boolean> save(@PathVariable("id") Long id, @RequestBody AccountUpdateRequest request) {

        AccountUpdateCommand command = new AccountUpdateCommand(new AccountId(id), new Money(request.getCurrency(), request.getAmount()));

        accountService.updateAmount(command);

        return new Result<>(200, "update amount success!", Boolean.TRUE);
    }

}
