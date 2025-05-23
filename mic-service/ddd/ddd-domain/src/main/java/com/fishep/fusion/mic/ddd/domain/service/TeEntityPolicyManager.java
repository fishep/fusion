package com.fishep.fusion.mic.ddd.domain.service;

import java.util.ArrayList;

/**
 * @Author fly.fei
 * @Date 2024/12/6 16:19
 * @Desc
 **/
public class TeEntityPolicyManager<T1, T2, T3, R, P extends TeEntityPolicy<T1, T2, T3, R>> extends ArrayList<P> {

    /**
     * @param entity1 应用于策略的实体
     * @param entity2 应用于策略的实体
     * @param entity3 应用于策略的实体
     * @return 返回符合条件的策略执行之后的对象，如果没有策略符合, 则默认返回null
     */
    public R apply(T1 entity1, T2 entity2, T3 entity3) {
        for (P policy : this) {
            if (!policy.test(entity1, entity2, entity3)) {
                continue;
            }
            return policy.apply(entity1, entity2, entity3);
        }

        return null;
    }

}
