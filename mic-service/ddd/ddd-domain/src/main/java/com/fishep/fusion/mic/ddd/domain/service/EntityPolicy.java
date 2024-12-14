package com.fishep.fusion.mic.ddd.domain.service;

/**
 * @Author fly.fei
 * @Date 2024/12/6 11:11
 * @Desc 领域服务策略泛型类, 使用时先判断是否可以使用此策略，然后执行策略
 * Type parameters:
 * <T> – 应用于策略的实体类型
 * <R> – 策略执行之后返回的类型
 **/
//public interface EntityPolicy<T, R> extends Predicate<T>, Function<T, R> {
public interface EntityPolicy<T, R> {

    /**
     * 根据实体判断是否使用此策略
     *
     * @param entity 实体对象
     * @return 应用此策略返回true，否则返回false
     */
    boolean test(T entity);

    /**
     * 执行策略
     *
     * @param entity 实体对象
     * @return 策略执行之后返回的对象，可以为null
     */
    R apply(T entity);

}
