package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.repository.AccountRepository;
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

        AccountId accountId1 = new AccountId(1572870916451594444L);
        AccountId accountId2 = new AccountId(1572870916451594445L);
        AccountId accountId3 = new AccountId(1572870916451594446L);

        Account account1 = accountRepository.find(accountId1);
        assertNotNull(account1);

        Account account2 = accountRepository.find(accountId2);
        assertNotNull(account2);

        assertThrows(Exception.class, ()->{
            accountRepository.find(accountId3);
        });

    }

    @Test
    void save() {
    }
}