package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/26 11:45
 * @Desc
 **/
class IdentifierTest {

    public class IdentifierType extends Identifier {
        public IdentifierType(String value) {
            super(value);
        }
    }

    @Test
    void create() {
        assertThrows(ValidateException.class, () -> { new IdentifierType(null); });
        assertThrows(ValidateException.class, () -> { new IdentifierType(""); });
        assertThrows(ValidateException.class, () -> { new IdentifierType(" "); });

        assertDoesNotThrow(() -> { new IdentifierType("a"); });
        assertDoesNotThrow(() -> { new IdentifierType(" a "); });

        assertEquals("a", new IdentifierType(" a ").getValue());
        assertEquals("a", new IdentifierType(" a").getValue());
        assertEquals("a", new IdentifierType("a ").getValue());
        assertEquals("a", new IdentifierType("a").getValue());
    }

}