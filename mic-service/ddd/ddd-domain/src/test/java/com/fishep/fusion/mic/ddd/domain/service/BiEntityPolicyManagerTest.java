package com.fishep.fusion.mic.ddd.domain.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @Author fly.fei
 * @Date 2024/12/6 16:31
 * @Desc
 **/
class BiEntityPolicyManagerTest {

    @Test
    void apply() {
        BiEntityPolicy<Integer, Integer, String> policy0 = new BiEntityPolicy<>() {
            @Override
            public boolean test(Integer entity1, Integer entity2) {
                return entity1 == 0 && entity2 == 0;
            }

            @Override
            public String apply(Integer entity1, Integer entity2) {
                return null;
            }
        };
        BiEntityPolicy<Integer, Integer, String> policy1 = new BiEntityPolicy<>() {
            @Override
            public boolean test(Integer entity1, Integer entity2) {
                return entity1 == 1 && entity2 == 1;
            }

            @Override
            public String apply(Integer entity1, Integer entity2) {
                return "policy1";
            }
        };
        BiEntityPolicy<Integer, Integer, String> policy2 = new BiEntityPolicy<>() {
            @Override
            public boolean test(Integer entity1, Integer entity2) {
                return entity1 == 2 && entity2 == 2;
            }

            @Override
            public String apply(Integer entity1, Integer entity2) {
                return "policy2";
            }
        };

        BiEntityPolicyManager<Integer, Integer, String, BiEntityPolicy<Integer, Integer, String>> manager = new BiEntityPolicyManager<>();
        manager.add(policy0);
        manager.add(policy1);
        manager.add(policy2);

        assertNull(manager.apply(0, 0));
        assertNull(manager.apply(1, 0));
        assertEquals(manager.apply(1, 1), "policy1");
        assertEquals(manager.apply(2, 2), "policy2");
    }

}