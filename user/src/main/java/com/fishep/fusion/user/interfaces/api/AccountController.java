package com.fishep.fusion.user.interfaces.api;

import com.fishep.fusion.common.annotation.ResultHandler;
import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.user.application.cqe.AccountQueryCommand;
import com.fishep.fusion.user.application.dto.AccountDTO;
import com.fishep.fusion.user.application.service.AccountService;
import com.fishep.fusion.user.interfaces.converter.AccountConverter;
import com.fishep.fusion.user.interfaces.request.AccountRequest;
import com.fishep.fusion.user.interfaces.response.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
