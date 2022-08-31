package com.fishep.fusion.common.type;

import com.fishep.fusion.common.exception.EmailPatternException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void newEmail() {
        assertThrows(EmailPatternException.class, () -> new Email("test"));
        assertThrows(EmailPatternException.class, () -> new Email("@fishep.com"));

        Email email = new Email("test@fishep.com");
        assertEquals("test@fishep.com", email.getValue());
    }
}