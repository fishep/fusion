package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.Money;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void test() {
        Account account = new Account(new AccountId(), new Money(new Currency("CNY"), 10000), Instant.now(), Instant.now());
        assertNotNull(account.getId().getValue());

        Boolean flag = account.deduct(new Money(new Currency("CNY"), 1000));
        assertTrue(flag);
        assertEquals(9000, account.getAmount().getValue());

        assertThrows(Exception.class, () -> {
            account.deduct(new Money("USD", 2));
        });
    }

}