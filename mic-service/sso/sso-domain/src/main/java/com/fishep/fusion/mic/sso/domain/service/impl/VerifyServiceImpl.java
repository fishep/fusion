package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.ddd.domain.service.EntityPolicy;
import com.fishep.fusion.mic.ddd.domain.service.EntityPolicyManager;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.service.CheckService;
import com.fishep.fusion.mic.sso.domain.service.VerifyService;
import com.fishep.fusion.mic.sso.domain.type.*;

import java.util.function.Supplier;

/**
 * @Author fly.fei
 * @Date 2024/12/27 18:26
 * @Desc
 **/
public class VerifyServiceImpl implements VerifyService {

    @Override
    public boolean verify(User user, Certificate certificate) {
        return verify(user, () -> {
            return certificate;
        });
    }

    @Override
    public boolean verify(User user, Supplier<Certificate> supplier) {
        VerifyManager manager = new VerifyManager(() -> {
            CheckService checkService = new CheckServiceImpl();
            return checkService.check(user, supplier.get());
        });

        if (user == null || user.getIdentifier() == null) {
            return Boolean.FALSE;
        }

        Boolean verify = manager.apply(user);
        return verify == null ? Boolean.FALSE : verify;
    }

    public class VerifyManager extends EntityPolicyManager<User, Boolean, EntityPolicy<User, Boolean>> {
        public VerifyManager(Supplier<Boolean> checkServiceCallback) {
            add(new UserNameVerifyPolicy());
            add(new EmailVerifyPolicy(checkServiceCallback));
            add(new PhoneNumberVerifyPolicy(checkServiceCallback));
        }
    }

    public class UserNameVerifyPolicy implements EntityPolicy<User, Boolean> {
        @Override
        public boolean test(User user) {
            return user.getIdentifier() instanceof UserName;
        }

        @Override
        public Boolean apply(User user) {
            return Boolean.TRUE;
        }
    }

    public class EmailVerifyPolicy implements EntityPolicy<User, Boolean> {
        private Supplier<Boolean> checkServiceCallback;

        public EmailVerifyPolicy(Supplier<Boolean> checkServiceCallback) {
            this.checkServiceCallback = checkServiceCallback;
        }

        @Override
        public boolean test(User user) {
            return user.getIdentifier() instanceof Email && user.getCertificate() instanceof VerificationCode;
        }

        @Override
        public Boolean apply(User user) {
            return checkServiceCallback.get();
        }
    }

    public class PhoneNumberVerifyPolicy implements EntityPolicy<User, Boolean> {
        private Supplier<Boolean> checkServiceCallback;

        public PhoneNumberVerifyPolicy(Supplier<Boolean> checkServiceCallback) {
            this.checkServiceCallback = checkServiceCallback;
        }

        @Override
        public boolean test(User user) {
            return user.getIdentifier() instanceof PhoneNumber && user.getCertificate() instanceof VerificationCode;
        }

        @Override
        public Boolean apply(User user) {
            return checkServiceCallback.get();
        }
    }

}
