package com.fishep.fusion.common.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountNumberTest {

    @Test
    void test() {
        AccountNumber accountNumber1 = new AccountNumber();
        AccountNumber accountNumber2 = new AccountNumber();
        AccountNumber accountNumber3 = new AccountNumber();

        System.out.println(accountNumber1.getValue());
        System.out.println(accountNumber2.getValue());
        System.out.println(accountNumber3.getValue());

        assertNotEquals(accountNumber1.getValue(), accountNumber2.getValue());
        assertNotEquals(accountNumber2.getValue(), accountNumber3.getValue());
    }
}