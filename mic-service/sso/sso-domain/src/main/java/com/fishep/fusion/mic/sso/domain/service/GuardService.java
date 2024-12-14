package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.ddd.domain.entity.App;
import com.fishep.fusion.mic.ddd.domain.entity.User;

/**
 * @Author fly.fei
 * @Date 2024/12/6 10:32
 * @Desc 领域服务，守卫服务，负责控制 不同的人对不同的系统的访问控制
 **/
public interface GuardService {

    /**
     * 不同的人对不同的系统的访问控制
     *
     * @param user 用户
     * @param app  应用系统
     * @return 如果可以访问返回true，如果不可以访问返回false，永远不为null，默认返回 false
     */
    Boolean canAccess(User user, App app);

}
