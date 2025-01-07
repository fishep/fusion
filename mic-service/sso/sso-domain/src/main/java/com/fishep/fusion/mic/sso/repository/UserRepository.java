package com.fishep.fusion.mic.sso.repository;

import com.fishep.fusion.mic.ddd.domain.type.Id;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.Identifier;

/**
 * @Author fly.fei
 * @Date 2024/12/26 10:57
 * @Desc
 **/
public interface UserRepository {

    User find(Id id);

    /**
     * @param identifier
     * @param userClass
     * @param <T>
     * @return 查找用户，未找到返回null
     */
    //    User find(Identifier identifier, Class<? extends User> clazz);
    //    <T extends User> User find(Identifier identifier, T user);
    //    User find(Identifier identifier, User user);
    <T extends User> User find(Identifier identifier, Class<T> userClass);

    /**
     * 保存，但不会修改实体对象
     *
     * @param user
     * @return 成功返回true，失败返回false
     */
    boolean save(User user);

    /**
     * 保存，同时修改传入的实体对象, 将实体的数据存入数据库，同时加载数据库的数据到实体（如果失败则抛异常）
     *
     * @param user
     * @return 成功返回true，失败返回false
     */
    boolean sync(User user);

}
