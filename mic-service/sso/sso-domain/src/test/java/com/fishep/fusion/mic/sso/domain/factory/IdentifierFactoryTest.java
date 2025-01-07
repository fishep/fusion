package com.fishep.fusion.mic.sso.domain.factory;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.type.Email;
import com.fishep.fusion.mic.sso.domain.type.PhoneNumber;
import com.fishep.fusion.mic.sso.domain.type.UserName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/31 15:01
 * @Desc
 **/
class IdentifierFactoryTest {

    @Test
    void create() {
        assertThrows(ValidateException.class, ()->{ IdentifierFactory.create(null); });
        assertThrows(ValidateException.class, ()->{ IdentifierFactory.create(""); });
        assertThrows(ValidateException.class, ()->{ IdentifierFactory.create(" "); });

        assertInstanceOf(UserName.class, IdentifierFactory.create("test.test"));
        assertInstanceOf(Email.class, IdentifierFactory.create("test@email.com"));
        assertInstanceOf(PhoneNumber.class, IdentifierFactory.create("11111111111"));

        assertThrows(ValidateException.class, ()->{ IdentifierFactory.create(".test"); });
        assertThrows(ValidateException.class, ()->{ IdentifierFactory.create("test@"); });
        assertThrows(ValidateException.class, ()->{ IdentifierFactory.create("1111"); });
    }

}