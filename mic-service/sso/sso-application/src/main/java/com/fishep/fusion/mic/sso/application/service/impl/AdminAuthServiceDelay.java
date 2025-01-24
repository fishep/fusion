package com.fishep.fusion.mic.sso.application.service.impl;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.application.cqe.ActivateCmd;
import com.fishep.fusion.mic.sso.application.cqe.LoginCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterAdminCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterCmd;
import com.fishep.fusion.mic.sso.application.dto.TokenDto;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.Password;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;

/**
 * @Author fly.fei
 * @Date 2025/1/20 11:23
 * @Desc 后台管理员认证流程
 * 后台管理员添加用户，系统发送邮件给用户，用户登录
 * 用户注册(管理员添加用户，发送验证码)->激活（发送随机密码）->登录
 **/
public class AdminAuthServiceDelay extends AbstractAuthServiceDelay {

    public AdminAuthServiceDelay(Context context) {
        super(context);
    }

    @Override
    public void register(RegisterCmd registerCmd) {
        if (registerCmd instanceof RegisterAdminCmd registerAdminCmd) {
            register(registerAdminCmd);
        }

        throw new ValidateException("Unsupported registration command");
    }

    public void register(RegisterAdminCmd registerAdminCmd) {
        User user = registerAdminCmd.getUser(authPairService, certificateHashService);

        register(() -> {
            return user;
        });

        generateRandomCertificateThenSend(user, VerificationCode.class);
    }

    @Override
    public void activate(ActivateCmd activateCmd) {
        User user = userRepository.findOrException(activateCmd.getIdentifierEntity(), activateCmd.getUserType());

        activate(() -> {
            return user;
        }, activateCmd::getVerificationCodeEntity);

        generateRandomCertificateThenSend(user, Password.class);
    }

    @Override
    public TokenDto login(LoginCmd loginCmd) {
        User user = userRepository.findOrException(loginCmd.getIdentifierEntity(), loginCmd.getUserType());

        return login(() -> {
            return user;
        }, loginCmd::getCertificateEntity);
    }

}
