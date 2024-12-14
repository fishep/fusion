package com.fishep.fusion.mic.ddd.domain.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @Author fly.fei
 * @Date 2024/12/6 15:19
 * @Desc
 **/
class EntityPolicyManagerTest {

    @Test
    void apply() {
        EntityPolicy<Integer, String> policy0 = new EntityPolicy<>() {
            @Override
            public boolean test(Integer entity) {
                return entity == 0;
            }

            @Override
            public String apply(Integer entity) {
                return null;
            }
        };

        EntityPolicy<Integer, String> policy1 = new EntityPolicy<>() {
            @Override
            public boolean test(Integer entity) {
                return entity == 1;
            }

            @Override
            public String apply(Integer entity) {
                return "policy1";
            }
        };

        EntityPolicy<Integer, String> policy2 = new EntityPolicy<>() {
            @Override
            public boolean test(Integer entity) {
                return entity == 2;
            }

            @Override
            public String apply(Integer entity) {
                return "policy2";
            }
        };

        EntityPolicyManager<Integer, String, EntityPolicy<Integer, String>> manager = new EntityPolicyManager<>();

        manager.add(policy0);
        manager.add(policy1);
        manager.add(policy2);

        assertNull(manager.apply(0));
        assertEquals(manager.apply(1), "policy1");
        assertEquals(manager.apply(2), "policy2");
        assertNull(manager.apply(3));
    }

}