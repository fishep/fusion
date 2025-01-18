package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.ddd.domain.service.EntityPolicy;
import com.fishep.fusion.mic.ddd.domain.service.EntityPolicyManager;
import com.fishep.fusion.mic.sso.domain.entity.User;
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
        VerifyManager manager = new VerifyManager(supplier);

        if (user == null || user.getIdentifier() == null) {
            return Boolean.FALSE;
        }

        Boolean verify = manager.apply(user);
        return verify == null ? Boolean.FALSE : verify;
    }

    public class VerifyManager extends EntityPolicyManager<User, Boolean, EntityPolicy<User, Boolean>> {
        public VerifyManager(Supplier<Certificate> certificateSupplier) {
            add(new UserNameVerifyPolicy());
            add(new EmailVerifyPolicy(certificateSupplier));
            add(new PhoneNumberVerifyPolicy(certificateSupplier));
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
        private Supplier<Certificate> certificateSupplier;

        public EmailVerifyPolicy(Supplier<Certificate> certificateSupplier) {
            this.certificateSupplier = certificateSupplier;
        }

        @Override
        public boolean test(User user) {
            return user.getIdentifier() instanceof Email && user.getCertificate() instanceof VerificationCode;
        }

        @Override
        public Boolean apply(User user) {
            return user.getCertificate().equals(certificateSupplier.get());
        }
    }

    public class PhoneNumberVerifyPolicy implements EntityPolicy<User, Boolean> {
        private Supplier<Certificate> certificateSupplier;

        public PhoneNumberVerifyPolicy(Supplier<Certificate> certificateSupplier) {
            this.certificateSupplier = certificateSupplier;
        }

        @Override
        public boolean test(User user) {
            return user.getIdentifier() instanceof PhoneNumber && user.getCertificate() instanceof VerificationCode;
        }

        @Override
        public Boolean apply(User user) {
            return user.getCertificate().equals(certificateSupplier.get());
        }
    }

}
