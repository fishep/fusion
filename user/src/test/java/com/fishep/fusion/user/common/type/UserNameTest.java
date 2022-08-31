package com.fishep.fusion.user.common.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNameTest {

    @Test
    void newUserName() {
        UserName name = new UserName("aaa.bbb.ccc");
        assertEquals("aaa.bbb.ccc", name.getValue());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new UserName(".aaa"));
        System.out.println(exception.getMessage());

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> new UserName("中文"));
        System.out.println(exception1.getMessage());
    }

    @Test
    void setValue() {
        UserName name = new UserName("aaa.bbb.ccc");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> name.setValue("中文"));
        System.out.println(exception.getMessage());
    }
}