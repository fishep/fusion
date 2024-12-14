package com.fishep.fusion.mic.ddd.domain.service;

import java.util.ArrayList;

/**
 * @Author fly.fei
 * @Date 2024/12/6 11:10
 * @Desc 领域服务策略管理者，负责管理策略
 * <T> – 应用于策略的实体类型
 * <R> – 策略执行之后返回的类型
 * <P> – 策略
 **/
public class EntityPolicyManager<T, R, P extends EntityPolicy<T, R>> extends ArrayList<P> {

    /**
     * @param entity 应用于策略的实体
     * @return 返回符合条件的策略执行之后的对象，如果没有策略符合, 则默认返回null
     */
    public R apply(T entity) {
        for (P policy : this) {
            if (!policy.test(entity)) {
                continue;
            }
            return policy.apply(entity);
        }

        return null;
    }

}
