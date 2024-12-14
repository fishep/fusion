package com.fishep.fusion.mic.ddd.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/5 15:04
 * @Desc
 **/
class IdTest {

    @Test
    void autoIncrement() {
        Id id1 = new Id();
        assertNotNull(id1.getValue());

        Id id2 = new Id();
        assertNotNull(id2.getValue());

        assertTrue(id1.getValue() < id2.getValue());
    }

    @Test
    void validation() {
        assertThrows(ValidationException.class, () -> { new Id(Long.MIN_VALUE); });
        assertThrows(ValidationException.class, () -> { new Id(-1L); });
        assertThrows(ValidationException.class, () -> { new Id(0L); });
        assertDoesNotThrow(() -> { new Id(1L); });
        assertDoesNotThrow(() -> { new Id(Long.MAX_VALUE); });
    }

}