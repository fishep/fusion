package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.order.common.type.AccountId;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void test() {
        Account account = new Account(new AccountId(), new Money(new Currency("CNY"), 10000), Instant.now(), Instant.now());
        assertNotNull(account.getId().getId());

        Boolean flag = account.deduct(new Money(new Currency("CNY"), 1000));
        assertTrue(flag);
        assertEquals(9000, account.getAmount().getAmount());

        assertThrows(Exception.class, ()->{ account.deduct(new Money("USD", 2)); });
    }

}