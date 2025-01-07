package com.fishep.fusion.mic.sso.application.service.impl;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.application.cqe.RegisterCmd;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.App;

/**
 * @Author fly.fei
 * @Date 2025/1/3 17:12
 * @Desc 宽松的认证流程，不验证标识符是否为其所有
 * 用户注册->用户登录
 **/
public class AuthServiceLooseImpl extends AuthServiceImpl {

    @Override
    public void register(RegisterCmd registerCmd) {
        App app = registerCmd.getApp();
        User user = registerCmd.getUser(authPairService, certificateHashService);

        if (!accessService.canAccess(user, app)) {
            throw new ValidateException("User access system denied");
        }

        User existingUser = userRepository.find(user.getIdentifier(), user.getClass());
        if (existingUser != null) {
            throw new ValidateException("The user already exists");
        }

        boolean saveFlag = userRepository.save(user);
        if (!saveFlag) {
            throw new ValidateException("User save failed");
        }
    }

}
