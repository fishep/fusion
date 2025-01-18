package com.fishep.fusion.mic.sso.application.service.impl;

import com.fishep.fusion.mic.sso.application.cqe.SendVerificationCodeCmd;
import com.fishep.fusion.mic.sso.application.dto.VerificationCodeDto;
import com.fishep.fusion.mic.sso.application.service.AuthService;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.service.AccessService;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.*;
import com.fishep.fusion.mic.sso.message.CertificateMessageSender;
import com.fishep.fusion.mic.sso.repository.CertificateRepository;
import com.fishep.fusion.mic.sso.repository.UserRepository;
import lombok.Getter;

import java.util.function.Function;

/**
 * @Author fly.fei
 * @Date 2024/12/24 12:02
 * @Desc
 **/
public abstract class AbstractAuthService implements AuthService {

    @Getter
    public static class Context {

        private App app;

        public Context(App app) {
            this.app = app;
        }
    }

    @Getter
    protected Context context;

    protected AccessService accessService;

    protected AuthPairService authPairService;

    protected CertificateHashService certificateHashService;

    protected UserRepository userRepository;

    protected CertificateRepository certificateRepository;

    protected CertificateMessageSender certificateMessageSender;

    public AbstractAuthService(Context context) {
        this.context = context;
    }

    @Override
    public VerificationCodeDto sendVerificationCode(SendVerificationCodeCmd sendVerificationCodeCmd) {

        Certificate certificate = generateRandomCertificateThenSend(sendVerificationCodeCmd.getIdentifierEntity(), sendVerificationCodeCmd.getUserType(), VerificationCode.class);

        return null;
    }

    public Certificate generateRandomCertificateThenSend(User user, Class<? extends Certificate> clazz) {
        return generateRandomCertificateThenSend(user.getIdentifier(), user.getClass(), clazz);
    }

    public Certificate generateRandomCertificateThenSend(Identifier identifier, Class<? extends User> uClazz, Class<? extends Certificate> cClazz) {
        Certificate certificate = new CertificateFactory(certificateHashService).generate(cClazz);
        certificateRepository.saveOrException(uClazz, identifier, certificate);

        CertificateMessage certificateMessage = new CertificateMessage(identifier, certificate);
        certificateMessageSender.send(certificateMessage);

        return certificate;
    }

    public void check(User user, Function<CertificateHashService, ? extends Certificate> certificateSupplier) {
        Certificate certificate = certificateSupplier.apply(certificateHashService);
        Certificate stub = certificateRepository.findOrException(user.getClass(), user.getIdentifier(), certificate.getClass());
        certificate.assertEquals(stub);
    }

}
