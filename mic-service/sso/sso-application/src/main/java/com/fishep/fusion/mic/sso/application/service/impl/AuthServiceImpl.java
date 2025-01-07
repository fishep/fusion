package com.fishep.fusion.mic.sso.application.service.impl;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.application.cqe.ActivateCmd;
import com.fishep.fusion.mic.sso.application.cqe.LoginCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterCmd;
import com.fishep.fusion.mic.sso.application.cqe.SendVerificationCodeCmd;
import com.fishep.fusion.mic.sso.application.dto.TokenDto;
import com.fishep.fusion.mic.sso.application.dto.VerificationCodeDto;
import com.fishep.fusion.mic.sso.application.service.AuthService;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.service.*;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;
import com.fishep.fusion.mic.sso.domain.type.VerificationMessage;
import com.fishep.fusion.mic.sso.message.VerificationMessageSender;
import com.fishep.fusion.mic.sso.repository.CertificateRepository;
import com.fishep.fusion.mic.sso.repository.UserRepository;

/**
 * @Author fly.fei
 * @Date 2024/12/24 12:02
 * @Desc
 **/
public abstract class AuthServiceImpl implements AuthService {

    protected AccessService accessService;

    protected AuthPairService authPairService;

    protected CheckService checkService;

    protected ActivateService activateService;

    protected CertificateHashService certificateHashService;

    protected UserRepository userRepository;

    protected CertificateRepository certificateRepository;

    protected VerificationMessageSender verificationMessageSender;

    @Override
    public void register(RegisterCmd registerCmd) {
    }

    @Override
    public VerificationCodeDto sendVerificationCodeCmd(SendVerificationCodeCmd sendVerificationCodeCmd) {
        VerificationCode verificationCode = new CertificateFactory(certificateHashService).generateVerificationCode();
        certificateRepository.save(sendVerificationCodeCmd.getUserType(), sendVerificationCodeCmd.getIdentifierInstance(), verificationCode);

        VerificationMessage verificationMessage = new VerificationMessage(sendVerificationCodeCmd.getIdentifierInstance(), verificationCode);
        verificationMessageSender.send(verificationMessage);

        return null;
    }

    @Override
    public void activate(ActivateCmd activateCmd) {
        User user = userRepository.find(activateCmd.getIdentifierInstance(), activateCmd.getUserType());
        if (user == null) {
            throw new ValidateException("The user not exists");
        }

        Certificate certificate = certificateRepository.find(user.getClass(), user.getIdentifier(), VerificationCode.class);

        user.setAuthPair(certificate, authPairService);

        activateService.activate(user, activateCmd.getVerificationCode(certificateHashService));

        userRepository.save(user);
    }

    @Override
    public TokenDto login(LoginCmd loginCmd) {
        User user = userRepository.find(loginCmd.getIdentifierInstance(), loginCmd.getUserType());
        if (user == null) {
            throw new ValidateException("The user not exists");
        }

        if (!user.isActivated()) {
            throw new ValidateException("User not activated");
        }

        boolean checkFlag = checkService.check(user, () -> {
            return certificateRepository.find(user.getClass(), user.getIdentifier(), user.getCertificate().getClass());
        });
        if (!checkFlag) {
            throw new ValidateException("login failed");
        }

        return null;
    }

}
