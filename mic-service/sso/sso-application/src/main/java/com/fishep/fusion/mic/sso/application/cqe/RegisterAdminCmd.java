package com.fishep.fusion.mic.sso.application.cqe;

import cn.hutool.core.util.StrUtil;
import com.fishep.fusion.mic.sso.domain.entity.Admin;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.factory.IdentifierFactory;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.AdminId;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2024/12/26 10:31
 * @Desc
 **/
@Getter
public class RegisterAdminCmd extends RegisterCmd {



    @Override
    public User getUser(AuthPairService authPairService, CertificateHashService certificateHashService) {
        Admin admin = new Admin(new AdminId(), IdentifierFactory.create(identifier));

        if (!StrUtil.isBlank(password)) {
            admin.setAuthPair(CertificateFactory.create(password, certificateHashService), authPairService);
        }

        return admin;
    }

}
