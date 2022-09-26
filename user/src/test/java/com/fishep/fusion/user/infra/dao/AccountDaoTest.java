package com.fishep.fusion.user.infra.dao;

import com.fishep.fusion.user.infra.model.AccountDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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

}