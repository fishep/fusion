package com.fishep.fusion.mic.ddd.domain.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @Author fly.fei
 * @Date 2024/12/6 16:31
 * @Desc
 **/
class TeEntityPolicyManagerTest {

    @Test
    void apply() {
        TeEntityPolicy<Integer, Integer, Integer, String> policy0 = new TeEntityPolicy<>() {
            @Override
            public boolean test(Integer entity1, Integer entity2, Integer entity3) {
                return entity1 == 0 && entity2 == 0 && entity3 == 0;
            }

            @Override
            public String apply(Integer entity1, Integer entity2, Integer entity3) {
                return null;
            }
        };
        TeEntityPolicy<Integer, Integer, Integer, String> policy1 = new TeEntityPolicy<>() {
            @Override
            public boolean test(Integer entity1, Integer entity2, Integer entity3) {
                return entity1 == 1 && entity2 == 1 && entity3 == 1;
            }

            @Override
            public String apply(Integer entity1, Integer entity2, Integer entity3) {
                return "policy1";
            }
        };
        TeEntityPolicy<Integer, Integer, Integer, String> policy2 = new TeEntityPolicy<>() {
            @Override
            public boolean test(Integer entity1, Integer entity2, Integer entity3) {
                return entity1 == 2 && entity2 == 2 && entity3 == 2;
            }

            @Override
            public String apply(Integer entity1, Integer entity2, Integer entity3) {
                return "policy2";
            }
        };

        TeEntityPolicyManager<Integer, Integer, Integer, String, TeEntityPolicy<Integer, Integer, Integer, String>> manager = new TeEntityPolicyManager<>();
        manager.add(policy0);
        manager.add(policy1);
        manager.add(policy2);

        assertNull(manager.apply(0, 0, 0));
        assertNull(manager.apply(1, 0, 0));
        assertEquals(manager.apply(1, 1, 1), "policy1");
        assertEquals(manager.apply(2, 2, 2), "policy2");
    }

}