package com.fishep.fusion.mic.sso.application.service.impl;

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
 * @Date 2025/1/3 16:37
 * @Desc 认证流程，先注册，验证标识符（邮箱，电话号码）为其所有之后才能使用
 * 用户注册（注册之后发送验证码）->激活->登录
 **/
public abstract class AbstractAuthServiceDelay extends AbstractAuthService {

    public AbstractAuthServiceDelay(Context context) {
        super(context);
    }

    public void register(Supplier<User> userSupplier) {
        User user = userSupplier.get();

        App app = getContext().getApp();

        accessService.assertCanAccess(user, app);

        userRepository.assertNotExist(user);

        userRepository.saveOrException(user);

//        generateRandomCertificateThenSend(user, VerificationCode.class);
    }

    public void activate(Supplier<User> userSupplier, Function<CertificateHashService, VerificationCode> certificateSupplier) {
        User user = userSupplier.get();

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

}
