package com.fishep.fusion.mic.ddd.domain.service;

/**
 * @Author fly.fei
 * @Date 2024/12/6 16:26
 * @Desc
 **/
public interface TeEntityPolicy<T1, T2, T3, R> {

    /**
     * 根据实体判断是否使用此策略
     *
     * @param entity1 实体对象
     * @param entity2 实体对象
     * @param entity3 实体对象
     * @return 应用此策略返回true，否则返回false
     */
    boolean test(T1 entity1, T2 entity2, T3 entity3);

    /**
     * 执行策略
     *
     * @param entity1 实体对象
     * @param entity2 实体对象
     * @param entity3 实体对象
     * @return 策略执行之后返回的对象，可以为null
     */
    R apply(T1 entity1, T2 entity2, T3 entity3);

}