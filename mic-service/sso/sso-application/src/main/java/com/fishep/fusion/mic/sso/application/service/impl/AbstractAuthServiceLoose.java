package com.fishep.fusion.mic.sso.application.service.impl;

import com.fishep.fusion.mic.sso.application.dto.TokenDto;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Certificate;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author fly.fei
 * @Date 2025/1/3 17:12
 * @Desc 宽松的认证流程，不验证标识符(邮箱，电话号码)是否为其所有
 * 用户注册->用户登录
 **/
public abstract class AbstractAuthServiceLoose extends AbstractAuthService {

    public AbstractAuthServiceLoose(Context context) {
        super(context);
    }

    public void register(Supplier<User> userSupplier) {
        User user = userSupplier.get();

        App app = getContext().getApp();

        accessService.assertCanAccess(user, app);

        userRepository.assertNotExist(user);

        userRepository.saveOrException(user);
    }

    public TokenDto login(Supplier<User> userSupplier, Function<CertificateHashService, Certificate> certificateSupplier) {
        User user = userSupplier.get();

        App app = getContext().getApp();

        accessService.assertCanAccess(user, app);

        check(user, certificateSupplier);

//        颁发token

        return null;
    }

}
