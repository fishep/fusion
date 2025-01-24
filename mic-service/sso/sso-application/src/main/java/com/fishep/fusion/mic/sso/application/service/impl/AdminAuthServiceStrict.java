package com.fishep.fusion.mic.sso.application.service.impl;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.application.cqe.LoginCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterAdminWithCodeCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterCmd;
import com.fishep.fusion.mic.sso.application.dto.TokenDto;
import com.fishep.fusion.mic.sso.domain.entity.User;

/**
 * @Author fly.fei
 * @Date 2025/1/20 10:50
 * @Desc 后台管理员认证流程
 * 后台管理员添加用户，系统发送邮件给用户，用户登录
 * 用户注册(管理员)->激活（发送随机密码）->登录
 * <p>
 * 发送验证码(管理员生成授权注册链接并发送给用户)->用户注册（先验证在保存）->用户登录
 **/
public class AdminAuthServiceStrict extends AbstractAuthServiceStrict {

    public AdminAuthServiceStrict(Context context) {
        super(context);
    }

    @Override
    public void register(RegisterCmd registerCmd) {
        if (registerCmd instanceof RegisterAdminWithCodeCmd registerAdminCmd) {
            register(registerAdminCmd);
        }

        throw new ValidateException("Unsupported registration command");
    }

    public void register(RegisterAdminWithCodeCmd registerAdminCmd) {
        User user = registerAdminCmd.getUser(authPairService, certificateHashService);

        register(() -> {
            return user;
        }, registerAdminCmd::getVerificationCodeEntity);

    }

    @Override
    public TokenDto login(LoginCmd loginCmd) {
        User user = userRepository.findOrException(loginCmd.getIdentifierEntity(), loginCmd.getUserType());

        return login(() -> {
            return user;
        }, loginCmd::getCertificateEntity);
    }

}
