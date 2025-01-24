package com.fishep.fusion.mic.sso.application.service.impl;

import com.fishep.fusion.mic.sso.application.cqe.ActivateCmd;
import com.fishep.fusion.mic.sso.application.dto.TokenDto;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author fly.fei
 * @Date 2025/1/3 17:11
 * @Desc 严格的认证流程，先验证标识符（邮箱，电话号码）为其所有，才能注册使用
 * 发送验证码->用户注册（先验证在保存）->用户登录
 **/
public abstract class AbstractAuthServiceStrict extends AbstractAuthService {

    public AbstractAuthServiceStrict(Context context) {
        super(context);
    }

    public void register(Supplier<User> userSupplier, Function<CertificateHashService, VerificationCode> certificateSupplier) {
        User user = userSupplier.get();

        App app = getContext().getApp();

        accessService.assertCanAccess(user, app);

        userRepository.assertNotExist(user);

        check(user, certificateSupplier);

        user.setActivated();

        userRepository.saveOrException(user);
    }

    public TokenDto login(Supplier<User> userSupplier, Function<CertificateHashService, Certificate> certificateSupplier) {
        User user = userSupplier.get();

        App app = getContext().getApp();

        accessService.assertCanAccess(user, app);

        user.assertActivated();

        check(user, certificateSupplier);

//        颁发token

        return null;
    }

    @Override
    public void activate(ActivateCmd activateCmd) {

    }

}
