package com.fishep.fusion.user.common.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserPasswordTest {

    @Test
    void newUserPassword() {
        assertThrows(IllegalArgumentException.class, ()-> new UserPassword("123456"));

        UserPassword userPassword = new UserPassword("12345678");
        assertEquals("12345678", userPassword.getValue());
    }
}