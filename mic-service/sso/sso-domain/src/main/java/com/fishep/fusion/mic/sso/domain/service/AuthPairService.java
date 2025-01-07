package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Identifier;

/**
 * @Author fly.fei
 * @Date 2024/12/19 16:18
 * @Desc 认证方式领域服务，负责控制 不同类型的用户 使用 不同类型的标识和不同类型的凭证 来验证
 **/
public interface AuthPairService {

    /**
     * 用户是否可以使用特定类型的标识和凭证
     *
     * @param user
     * @param identifier
     * @param certificate
     * @return 如果可以使用返回true，如果不可以使用返回false
     */
    boolean canUse(User user, Identifier identifier, Certificate certificate);

}
