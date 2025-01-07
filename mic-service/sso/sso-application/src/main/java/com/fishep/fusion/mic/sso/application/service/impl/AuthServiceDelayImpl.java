package com.fishep.fusion.mic.sso.application.service.impl;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.application.cqe.RegisterCmd;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;
import com.fishep.fusion.mic.sso.domain.type.VerificationMessage;

/**
 * @Author fly.fei
 * @Date 2025/1/3 16:37
 * @Desc 认证流程，验证标识符为其所有之后才能登录
 * 用户注册->发送验证码->激活->登录
 **/
public class AuthServiceDelayImpl extends AuthServiceImpl {

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

        VerificationCode verificationCode = new CertificateFactory(certificateHashService).generateVerificationCode();
        certificateRepository.save(user.getClass(), user.getIdentifier(), verificationCode);

        VerificationMessage verificationMessage = new VerificationMessage(user.getIdentifier(), verificationCode);
        verificationMessageSender.send(verificationMessage);
    }

}
