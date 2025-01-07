package com.fishep.fusion.mic.sso.application.service.impl;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.application.cqe.RegisterCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterWithCodeCmd;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;

/**
 * @Author fly.fei
 * @Date 2025/1/3 17:11
 * @Desc 严格的认证流程，先证明标识符为其所有，在注册
 * 发送验证码->用户注册->用户登录
 **/
public class AuthServiceStrictImpl extends AuthServiceImpl {

    @Override
    public void register(RegisterCmd registerCmd) {
        if (registerCmd instanceof RegisterWithCodeCmd registerWithCodeCmd) {
            register(registerWithCodeCmd);
        }

        throw new ValidateException("Unsupported registration command");
    }

    public void register(RegisterWithCodeCmd registerCmd) {
        App app = registerCmd.getApp();
        User user = registerCmd.getUser(authPairService, certificateHashService);

        if (!accessService.canAccess(user, app)) {
            throw new ValidateException("User access system denied");
        }

        User existingUser = userRepository.find(user.getIdentifier(), user.getClass());
        if (existingUser != null) {
            throw new ValidateException("The user already exists");
        }

        Certificate certificate = certificateRepository.find(user.getClass(), user.getIdentifier(), VerificationCode.class);

        user.setAuthPair(certificate, authPairService);

        activateService.activate(user, registerCmd.getVerificationCode(certificateHashService));
        if (!user.isActivated()) {
            throw new ValidateException("Verification failed");
        }

        boolean saveFlag = userRepository.save(user);
        if (!saveFlag) {
            throw new ValidateException("User save failed");
        }
    }

}
