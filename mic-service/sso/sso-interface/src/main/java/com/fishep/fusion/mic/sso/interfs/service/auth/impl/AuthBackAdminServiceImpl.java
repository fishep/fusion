package com.fishep.fusion.mic.sso.interfs.service.auth.impl;

import com.fishep.fusion.mic.sso.application.cqe.GenerateAuthorizationCodeCmd;
import com.fishep.fusion.mic.sso.application.cqe.LoginCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterWithAVCmd;
import com.fishep.fusion.mic.sso.application.cqe.SendVerificationCodeCmd;
import com.fishep.fusion.mic.sso.application.dto.AuthorizationCodeDto;
import com.fishep.fusion.mic.sso.application.dto.TokenDto;
import com.fishep.fusion.mic.sso.application.service.AuthService;
import com.fishep.fusion.mic.sso.domain.entity.Admin;
import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.factory.IdentifierFactory;
import com.fishep.fusion.mic.sso.domain.type.*;
import com.fishep.fusion.mic.sso.interfs.req.auth.GenerateAuthorizationCodeReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.LoginReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterWithAVReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendVerificationCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.GenerateAuthorizationCodeRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendVerificationCodeRes;
import com.fishep.fusion.mic.sso.interfs.service.auth.AuthBackAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author fly.fei
 * @Date 2025/3/27 17:48
 * @Desc
 **/
@Component
public class AuthBackAdminServiceImpl implements AuthBackAdminService {

    private App app = new Back();

    @Autowired
    private AuthService authService;

    @Override
    public LoginRes login(LoginReq req) {
        LoginCmd<Admin> cmd = new LoginCmd<>();
        cmd.setApp(app);
        cmd.setAccountClass(Admin.class);
        cmd.setIdentifier(IdentifierFactory.create(req.getIdentifier()));
        cmd.setCertificate(CertificateFactory.createLoginCertificate(req.getCertificate()));

        TokenDto dto = authService.login(cmd);

        LoginRes loginRes = new LoginRes();
        loginRes.setToken("access_token");
        return loginRes;
    }

    @Override
    public SendVerificationCodeRes sendLoginVerificationCode(SendVerificationCodeReq req) {
        SendVerificationCodeCmd<Admin> cmd = new SendVerificationCodeCmd<>();
        cmd.setApp(app);
        cmd.setAccountClass(Admin.class);
        cmd.setIdentifier(IdentifierFactory.create(req.getIdentifier()));

        Boolean result = authService.sendLoginVerificationCode(cmd);

        return null;
    }

    @Override
    public RegisterRes register(RegisterWithAVReq req) {
        RegisterWithAVCmd cmd = new RegisterWithAVCmd();
        cmd.setApp(app);
        cmd.setAccount(new Admin(new AdminId(), IdentifierFactory.create(req.getIdentifier())));
        cmd.setAuthorizationCode(new AuthorizationCode());
        cmd.setVerificationCode((VerificationCode) CertificateFactory.create(req.getVerificationCode()));

        TokenDto dto = authService.register(cmd);

        return null;
    }

    @Override
    public GenerateAuthorizationCodeRes generateAuthorizationCode(GenerateAuthorizationCodeReq req) {
        GenerateAuthorizationCodeCmd cmd = new GenerateAuthorizationCodeCmd();
        cmd.setApp(app);
        cmd.setAccount(null);
        cmd.setBody(req.getBody());

        AuthorizationCodeDto authorizationCodeDto = authService.generateAuthorizationCode(cmd);

        return null;
    }

    @Override
    public SendVerificationCodeRes sendRegisterVerificationCode(SendVerificationCodeReq req) {
        SendVerificationCodeCmd<Admin> cmd = new SendVerificationCodeCmd<>();
        cmd.setApp(app);
        cmd.setAccountClass(Admin.class);
        cmd.setIdentifier(IdentifierFactory.create(req.getIdentifier()));

        return null;
    }
}
