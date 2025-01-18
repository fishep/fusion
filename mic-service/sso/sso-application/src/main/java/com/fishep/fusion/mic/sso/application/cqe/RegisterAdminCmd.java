package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.Admin;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.IdentifierFactory;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.AdminId;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2024/12/26 10:31
 * @Desc 后台管理员添加用户，系统发送邮件给用户（随机密码），用户登录
 * 用户注册->发送密码->登录
 **/
@Data
public class RegisterAdminCmd extends RegisterCmd {

    public String field;

    @Override
    public User getUser(AuthPairService authPairService, CertificateHashService certificateHashService) {
        Admin admin = new Admin(new AdminId(), IdentifierFactory.create(identifier));
//        admin.setAuthPair(CertificateFactory.create(password, certificateHashService), authPairService);
//        admin.setField(field);

        return admin;
    }

}
