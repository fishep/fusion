package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.ddd.domain.service.EntityPolicy;
import com.fishep.fusion.mic.ddd.domain.service.EntityPolicyManager;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.service.ActivateService;
import com.fishep.fusion.mic.sso.domain.service.CheckService;
import com.fishep.fusion.mic.sso.domain.service.exception.CertificateException;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Email;
import com.fishep.fusion.mic.sso.domain.type.PhoneNumber;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;

import java.util.function.Supplier;

/**
 * @Author fly.fei
 * @Date 2024/12/31 16:51
 * @Desc
 **/
public class ActivateServiceImpl implements ActivateService {

    private CheckService checkService = new CheckServiceImpl();

    @Override
    public void activate(User user, Certificate certificate) {
        activate(user, () -> {
            return certificate;
        });
    }

    @Override
    public void activate(User user, Supplier<Certificate> supplier) {
        if (user == null || user.getIdentifier() == null || user.getCertificate() == null) {
            return;
        }

        if (user.isActivated()) {
            return;
        }

        ActivateManager manager = new ActivateManager(() -> {
            return checkService.check(user, supplier.get());
        });

        Boolean activate = manager.apply(user);
        if (activate == Boolean.TRUE) {
            user.setActivated();
        }
    }

    public class ActivateManager extends EntityPolicyManager<User, Boolean, EntityPolicy<User, Boolean>> {
        public ActivateManager(Supplier<Boolean> checkServiceCallback) {
            add(new EmailActivatePolicy(checkServiceCallback));
            add(new PhoneNumberActivatePolicy(checkServiceCallback));
        }
    }

    public class EmailActivatePolicy implements EntityPolicy<User, Boolean> {
        private Supplier<Boolean> checkServiceCallback;

        public EmailActivatePolicy(Supplier<Boolean> checkServiceCallback) {
            this.checkServiceCallback = checkServiceCallback;
        }

        @Override
        public boolean test(User user) {
            return user.getIdentifier() instanceof Email && user.getCertificate() instanceof VerificationCode;
        }

        @Override
        public Boolean apply(User user) {
            if (!checkServiceCallback.get()) {
                throw new CertificateException("The verification code is incorrect");
            }

            return Boolean.TRUE;
        }
    }

    public class PhoneNumberActivatePolicy implements EntityPolicy<User, Boolean> {
        private Supplier<Boolean> checkServiceCallback;

        public PhoneNumberActivatePolicy(Supplier<Boolean> checkServiceCallback) {
            this.checkServiceCallback = checkServiceCallback;
        }

        @Override
        public boolean test(User user) {
            return user.getIdentifier() instanceof PhoneNumber && user.getCertificate() instanceof VerificationCode;
        }

        @Override
        public Boolean apply(User user) {
            if (!checkServiceCallback.get()) {
                throw new CertificateException("The verification code is incorrect");
            }

            return Boolean.TRUE;
        }
    }

}
