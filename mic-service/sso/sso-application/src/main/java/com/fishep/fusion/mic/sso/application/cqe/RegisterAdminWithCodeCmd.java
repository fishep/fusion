package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.Admin;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.IdentifierFactory;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.AdminId;

/**
 * @Author fly.fei
 * @Date 2025/1/20 10:58
 * @Desc
 **/
public class RegisterAdminWithCodeCmd extends RegisterWithCodeCmd {

    public String field;

    @Override
    public User getUser(AuthPairService authPairService, CertificateHashService certificateHashService) {
        Admin admin = new Admin(new AdminId(), IdentifierFactory.create(identifier));
//        admin.setAuthPair(CertificateFactory.create(password, certificateHashService), authPairService);
//        admin.setField(field);

        return admin;
    }

}
