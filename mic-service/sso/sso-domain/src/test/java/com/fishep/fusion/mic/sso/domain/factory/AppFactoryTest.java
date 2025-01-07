package com.fishep.fusion.mic.sso.domain.factory;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.type.Back;
import com.fishep.fusion.mic.sso.domain.type.Mall;
import com.fishep.fusion.mic.sso.domain.type.Open;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/31 15:00
 * @Desc
 **/
class AppFactoryTest {

    @Test
    void create() {
        assertThrows(ValidateException.class, ()->{ AppFactory.create(null); });
        assertThrows(ValidateException.class, ()->{ AppFactory.create(""); });
        assertThrows(ValidateException.class, ()->{ AppFactory.create(" "); });

        assertInstanceOf(Back.class, AppFactory.create("back"));
        assertInstanceOf(Mall.class, AppFactory.create("mall"));
        assertInstanceOf(Open.class, AppFactory.create("open"));

        assertThrows(ValidateException.class, ()->{ AppFactory.create("other"); });
    }

}