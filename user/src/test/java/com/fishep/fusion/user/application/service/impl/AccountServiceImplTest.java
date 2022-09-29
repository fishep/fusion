package com.fishep.fusion.user.application.service.impl;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.user.application.cqe.AccountQueryCommand;
import com.fishep.fusion.user.application.cqe.AccountUpdateCommand;
import com.fishep.fusion.user.application.dto.AccountDTO;
import com.fishep.fusion.user.application.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AccountServiceImplTest {

    @Autowired
    AccountService accountService;

    @Test
    void query() {

        AccountQueryCommand command = new AccountQueryCommand(1572870916451594444L);

        AccountDTO accountDTO = accountService.query(command);

        assertNotNull(accountDTO);

        assertThrows(Exception.class, ()->{
            accountService.query(new AccountQueryCommand(1L));
        });

    }

    @Test
    void updateAmount() {

        AccountUpdateCommand command = new AccountUpdateCommand(new AccountId(1572870916451594444L), new Money("CNY", 100000));

        AccountDTO accountDTO = accountService.updateAmount(command);

        assertNotNull(accountDTO);

        assertThrows(Exception.class, ()->{
            AccountUpdateCommand command1 = new AccountUpdateCommand(new AccountId(1572870916451594444L), new Money("USD", 100000));
            AccountDTO accountDTO1 = accountService.updateAmount(command1);
        });

    }
}