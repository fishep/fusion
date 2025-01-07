package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.ddd.domain.service.EntityPolicy;
import com.fishep.fusion.mic.ddd.domain.service.EntityPolicyManager;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Password;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;

/**
 * @Author fly.fei
 * @Date 2024/12/23 14:06
 * @Desc
 **/
public class CertificateHashServiceImpl implements CertificateHashService {

    private Manager manager = new Manager();

    @Override
    public String hash(Certificate certificate) {
        return manager.apply(certificate);
    }

    public class Manager extends EntityPolicyManager<Certificate, String, EntityPolicy<Certificate, String>> {
        {
            add(new PasswordHash());
            add(new VerificationCodeHash());
        }
    }

    public class PasswordHash implements EntityPolicy<Certificate, String> {
        @Override
        public boolean test(Certificate entity) {
            return entity instanceof Password;
        }

        @Override
        public String apply(Certificate entity) {
            // 假装hash一下， @TODO
            return "PasswordHash:" + entity.getPlaintext();
        }
    }

    public class VerificationCodeHash implements EntityPolicy<Certificate, String> {
        @Override
        public boolean test(Certificate entity) {
            return entity instanceof VerificationCode;
        }

        @Override
        public String apply(Certificate entity) {
            // 假装hash一下， @TODO
            return "VerificationCodeHash:" + entity.getPlaintext();
        }
    }

}
