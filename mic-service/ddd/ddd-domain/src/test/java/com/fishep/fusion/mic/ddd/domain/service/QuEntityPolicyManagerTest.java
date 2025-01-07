package com.fishep.fusion.mic.ddd.domain.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @Author fly.fei
 * @Date 2024/12/20 11:18
 * @Desc
 **/
class QuEntityPolicyManagerTest {

    @Test
    void apply() {
        QuEntityPolicy<Integer, Integer, Integer, Integer, String> policy0 = new QuEntityPolicy<>() {
            @Override
            public boolean test(Integer entity1, Integer entity2, Integer entity3, Integer entity4) {
                return entity1 == 0 && entity2 == 0 && entity3 == 0 && entity4 == 0;
            }

            @Override
            public String apply(Integer entity1, Integer entity2, Integer entity3, Integer entity4) {
                return null;
            }
        };
        QuEntityPolicy<Integer, Integer, Integer, Integer, String> policy1 = new QuEntityPolicy<>() {
            @Override
            public boolean test(Integer entity1, Integer entity2, Integer entity3, Integer entity4) {
                return entity1 == 1 && entity2 == 1 && entity3 == 1 && entity4 == 1;
            }

            @Override
            public String apply(Integer entity1, Integer entity2, Integer entity3, Integer entity4) {
                return "policy1";
            }
        };
        QuEntityPolicy<Integer, Integer, Integer, Integer, String> policy2 = new QuEntityPolicy<>() {
            @Override
            public boolean test(Integer entity1, Integer entity2, Integer entity3, Integer entity4) {
                return entity1 == 2 && entity2 == 2 && entity3 == 2 && entity4 == 2;
            }

            @Override
            public String apply(Integer entity1, Integer entity2, Integer entity3, Integer entity4) {
                return "policy2";
            }
        };

        QuEntityPolicyManager<Integer, Integer, Integer, Integer, String, QuEntityPolicy<Integer, Integer, Integer, Integer, String>> manager = new QuEntityPolicyManager<>();
        manager.add(policy0);
        manager.add(policy1);
        manager.add(policy2);

        assertNull(manager.apply(0, 0, 0, 0));
        assertNull(manager.apply(1, 0, 0, 0));
        assertEquals(manager.apply(1, 1, 1, 1), "policy1");
        assertEquals(manager.apply(2, 2, 2, 2), "policy2");
    }
}