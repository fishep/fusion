package com.fishep.fusion.mic.sso.application.service.impl;

import cn.hutool.json.JSON;
import com.fishep.fusion.mic.sso.application.cqe.*;
import com.fishep.fusion.mic.sso.application.dto.AuthorizationCodeDto;
import com.fishep.fusion.mic.sso.application.dto.TokenDto;
import com.fishep.fusion.mic.sso.application.service.AuthService;
import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.service.*;
import com.fishep.fusion.mic.sso.domain.type.*;
import com.fishep.fusion.mic.sso.message.ActivateCodeSender;
import com.fishep.fusion.mic.sso.message.AuthorizationCodeSender;
import com.fishep.fusion.mic.sso.message.VerificationCodeSender;
import com.fishep.fusion.mic.sso.repository.AccountRepository;
import com.fishep.fusion.mic.sso.repository.ActivateCodeRepository;
import com.fishep.fusion.mic.sso.repository.AuthorizationCodeRepository;
import com.fishep.fusion.mic.sso.repository.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author fly.fei
 * @Date 2025/4/1 16:45
 * @Desc
 **/
@Component
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AccessService accessService;

    @Autowired
    private BindService authPairService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private AuthorizationCodeRepository authorizationCodeRepository;

    @Autowired
    private VerifyService verifyService;

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @Autowired
    private ActivateCodeRepository activateCodeRepository;

    @Autowired
    private ActivateCodeSender activateCodeSender;

    @Autowired
    private VerificationCodeSender verificationCodeSender;

    @Autowired
    private AuthorizationCodeSender authorizationCodeSender;

    @Override
    public TokenDto register(RegisterCmd cmd) {
        App app = cmd.getApp();
        Account account = cmd.getAccount();
        Password password = cmd.getPassword();

        account.setAuthPair(password, authPairService);

        accessService.assertCanAccess(account, app);

        accountRepository.saveOrException(account);

        Token token = tokenService.generate(account, app);

        return null;
    }

    @Override
    public TokenDto register(RegisterWithAuthorizeCmd cmd) {
        App app = cmd.getApp();
        Account account = cmd.getAccount();
        Password password = cmd.getPassword();
        AuthorizationCode authorizationCode = cmd.getAuthorizationCode();

        account.setAuthPair(password, authPairService);

        accessService.assertCanAccess(account, app);

        AuthorizationCode code = authorizationCodeRepository.findOrException(app, authorizationCode);

        authorizationService.assertApplySuccess(account, code);

        accountRepository.saveOrException(account);

        Token token = tokenService.generate(account, app);

        return null;
    }

    @Override
    public TokenDto register(RegisterWithAVCmd cmd) {
        App app = cmd.getApp();
        Account account = cmd.getAccount();
        Password password = cmd.getPassword();
        AuthorizationCode authorizationCode = cmd.getAuthorizationCode();
        VerificationCode verificationCode = cmd.getVerificationCode();

        account.setAuthPair(password, authPairService);

        accessService.assertCanAccess(account, app);

        AuthorizationCode aCode = authorizationCodeRepository.findOrException(app, authorizationCode);

        authorizationService.assertApplySuccess(account, aCode);

        VerificationCode vCode = verificationCodeRepository.findOrException(app, account);

        verifyService.assertVerifySuccess(verificationCode, vCode);

        accountRepository.saveOrException(account);

        Token token = tokenService.generate(account, app);

        return null;
    }

    @Override
    public TokenDto register(RegisterWithVerifyCmd cmd) {
        App app = cmd.getApp();
        Account account = cmd.getAccount();
        Password password = cmd.getPassword();
        VerificationCode verificationCode = cmd.getVerificationCode();

        account.setAuthPair(password, authPairService);

        accessService.assertCanAccess(account, app);

        VerificationCode vCode = verificationCodeRepository.findOrException(app, account);

        verifyService.assertVerifySuccess(verificationCode, vCode);

        accountRepository.saveOrException(account);

        Token token = tokenService.generate(account, app);

        return null;
    }

    @Override
    public Boolean registerAndSendActivateCode(RegisterCmd cmd) {
        App app = cmd.getApp();
        Account account = cmd.getAccount();
        Password password = cmd.getPassword();

        account.setAuthPair(password, authPairService);

        accessService.assertCanAccess(account, app);

        accountRepository.saveOrException(account);

        ActivateCode aCode = (ActivateCode) CertificateFactory.generate(ActivateCode.class);

        activateCodeRepository.saveOrException(app, account, aCode);

        activateCodeSender.send(app, account, aCode);

        return Boolean.TRUE;
    }

    @Override
    public Boolean registerAndSendActivateCode(RegisterWithAuthorizeCmd cmd) {
        App app = cmd.getApp();
        Account account = cmd.getAccount();
        Password password = cmd.getPassword();
        AuthorizationCode authorizationCode = cmd.getAuthorizationCode();

        account.setAuthPair(password, authPairService);

        accessService.assertCanAccess(account, app);

        AuthorizationCode code = authorizationCodeRepository.findOrException(app, authorizationCode);

        authorizationService.assertApplySuccess(account, code);

        accountRepository.saveOrException(account);

        ActivateCode aCode = (ActivateCode) CertificateFactory.generate(ActivateCode.class);

        activateCodeRepository.saveOrException(app, account, aCode);

        activateCodeSender.send(app, account, aCode);

        return Boolean.TRUE;
    }

    @Override
    public Boolean sendRegisterVerificationCode(SendVerificationCodeCmd cmd) {
        App app = cmd.getApp();
        Identifier identifier = cmd.getIdentifier();

        accountRepository.assertNotExist(identifier, cmd.getAccountClass());

        VerificationCode vCode = (VerificationCode) CertificateFactory.generate(VerificationCode.class);

        verificationCodeSender.send(app, identifier, cmd.getAccountClass(), vCode);

        return Boolean.TRUE;
    }

    @Override
    public AuthorizationCodeDto generateAuthorizationCode(GenerateAuthorizationCodeCmd cmd) {
        App app = cmd.getApp();
        Account account = cmd.getAccount();
        JSON body = cmd.getBody();

        AuthorizationCode aCode = (AuthorizationCode) CertificateFactory.generate(AuthorizationCode.class);
        aCode.setBody(cmd.getBody());

        authorizationCodeRepository.saveOrException(app, aCode);

        authorizationCodeSender.send(app, aCode);

        return null;
    }

    @Override
    public Boolean sendActivateCode(SendActivateCodeCmd cmd) {

        App app = cmd.getApp();
        Identifier identifier = cmd.getIdentifier();

        return null;
    }

    @Override
    public Boolean activate(ActivateCmd cmd) {

//        cmd.getIdentifier()
        // 获取激活码， 标识符 系统 用户
//        activateCodeRepository


        return null;
    }

    @Override
    public TokenDto login(LoginCmd cmd) {
        return null;
    }

    @Override
    public TokenDto loginAfterActivate(LoginCmd cmd) {
        return null;
    }

    @Override
    public Boolean sendLoginVerificationCode(SendVerificationCodeCmd cmd) {
        return null;
    }
}
