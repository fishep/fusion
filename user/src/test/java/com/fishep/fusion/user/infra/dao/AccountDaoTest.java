package com.fishep.fusion.user.infra.dao;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.AccountNumber;
import com.fishep.fusion.common.type.UserId;
import com.fishep.fusion.user.infra.model.AccountDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AccountDaoTest {

    @Autowired
    AccountDao accountDao;

    @Test
    void select() {
        AccountDO aDo = accountDao.select(1572870916451594444L);

        assertNotNull(aDo);
    }

    @Test
    void insert() {

        AccountDO accountDO = new AccountDO();
        accountDO.setId(new AccountId().getValue());
        accountDO.setNumber(new AccountNumber().getValue());
        accountDO.setUserId(new UserId(1572870916451598336L).getValue());
        accountDO.setName("fishep account");
        accountDO.setCurrency("CNY");
        accountDO.setAmount(10);
        accountDO.setQuota(10);
        accountDO.setCreatedAt(Instant.now().getEpochSecond());
        accountDO.setUpdatedAt(Instant.now().getEpochSecond());

        Boolean flag = accountDao.insert(accountDO);

        assertTrue(flag);
    }

    @Test
    void update() {
        AccountDO aDo = accountDao.select(1572870916451594444L);
        aDo.setAmount(100);
        aDo.setQuota(200);
        aDo.setUpdatedAt(Instant.now().getEpochSecond());

        Boolean flag = accountDao.update(aDo);

        assertTrue(flag);

        AccountDO aDo1 = accountDao.select(1572870916451594444L);

        assertEquals(aDo.getAmount(), aDo1.getAmount());
        assertEquals(aDo.getQuota(), aDo1.getQuota());
        assertEquals(aDo.getUpdatedAt(), aDo1.getUpdatedAt());
    }
}