package com.fishep.fusion.mic.ddd.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/5 15:04
 * @Desc
 **/
class IdTest {

    public class EntityId extends Id {
        public EntityId() {
        }

        public EntityId(Long value) {
            super(value);
        }
    }

    @Test
    void autoIncrement() {
        Id id1 = new EntityId();
        assertNotNull(id1.getValue());

        Id id2 = new EntityId();
        assertNotNull(id2.getValue());

        assertTrue(id1.getValue() < id2.getValue());
    }

    @Test
    void validation() {
        assertThrows(ValidateException.class, () -> { new EntityId(Long.MIN_VALUE); });
        assertThrows(ValidateException.class, () -> { new EntityId(-1L); });
        assertThrows(ValidateException.class, () -> { new EntityId(0L); });
        assertDoesNotThrow(() -> { new EntityId(1L); });
        assertDoesNotThrow(() -> { new EntityId(Long.MAX_VALUE); });
    }

}