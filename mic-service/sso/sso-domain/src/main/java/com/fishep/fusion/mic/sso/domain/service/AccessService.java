package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.App;

/**
 * @Author fly.fei
 * @Date 2024/12/6 10:32
 * @Desc 访问控制领域服务，负责控制 不同类型的人对不同的系统的访问控制
 **/
public interface AccessService {

    /**
     * 控制不同的人对不同的系统的访问
     *
     * @param user 用户
     * @param app  应用系统
     * @return 如果可以访问返回true，如果不可以访问返回false
     */
    boolean canAccess(User user, App app);

}
