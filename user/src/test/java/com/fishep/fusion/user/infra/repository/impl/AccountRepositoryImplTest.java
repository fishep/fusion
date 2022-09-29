package com.fishep.fusion.user.infra.repository.impl;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.UserId;
import com.fishep.fusion.user.domain.entity.Account;
import com.fishep.fusion.user.domain.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AccountRepositoryImplTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void find() {

        AccountId accountId = new AccountId(1572870916451594444L);

        Account account = accountRepository.find(accountId);

        assertNotNull(account);

        assertThrows(Exception.class, () -> {
            accountRepository.find(new AccountId(1L));
        });
    }

    @Test
    void save() {
        Account account = new Account(new UserId(1572870916451598336L), new Money("CNY", 100));

        assertTrue(accountRepository.save(account));

        account.deduct(new Money("CNY", 10));

        assertTrue(accountRepository.save(account));
    }
}