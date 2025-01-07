package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.UserFactory;
import com.fishep.fusion.mic.sso.domain.service.impl.AuthPairServiceImpl;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import com.fishep.fusion.mic.sso.domain.service.impl.CheckServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Password;
import com.fishep.fusion.mic.sso.domain.type.PhoneNumber;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author fly.fei
 * @Date 2024/12/28 10:22
 * @Desc
 **/
class CheckServiceTest {
    private static AuthPairService authPairService = new AuthPairServiceImpl();
    private static CertificateHashService hashService = new CertificateHashServiceImpl();

    private static User user1; // 没有验证信息
    private static User user2; // 密码验证
    private static User user3; // 验证码验证

    private static Certificate correctPassword = new Password("12345678", hashService);
    private static Certificate wrongPassword = new Password("87654321", hashService);
    private static Certificate correctVerificationCode = new VerificationCode("123456", hashService);
    private static Certificate wrongVerificationCode = new VerificationCode("654321", hashService);

    static {
        user1 = UserFactory.createCustomer();
        user2 = UserFactory.createCustomer();
        user2.setAuthPair(new PhoneNumber("11111111111"), new Password("12345678", hashService), authPairService);
        user3 = UserFactory.createCustomer();
        user3.setAuthPair(new PhoneNumber("11111111111"), new VerificationCode("123456", hashService), authPairService);
    }

    @Test
    void testCheckServiceImpl() {
        CheckServiceImpl service = new CheckServiceImpl();
        check1(service);
        check2(service);
        check3(service);
        check4(service);
    }

    void check1(CheckServiceImpl service) {
//        assertFalse(service.check(null, correctPassword));
//        assertFalse(service.check(null, correctVerificationCode));

        assertFalse(service.check(user1, correctPassword));
        assertFalse(service.check(user1, wrongPassword));
        assertFalse(service.check(user1, correctVerificationCode));
        assertFalse(service.check(user1, wrongVerificationCode));

        assertTrue(service.check(user2, correctPassword));
        assertFalse(service.check(user2, wrongPassword));
        assertFalse(service.check(user2, correctVerificationCode));
        assertFalse(service.check(user2, wrongVerificationCode));

        assertTrue(service.check(user3, correctVerificationCode));
        assertFalse(service.check(user3, wrongVerificationCode));
        assertFalse(service.check(user3, correctPassword));
        assertFalse(service.check(user3, wrongPassword));
    }

    void check2(CheckServiceImpl service) {
//        assertFalse(service.check(null, () -> { return correctPassword; }));
//        assertFalse(service.check(null, () -> { return correctVerificationCode; }));

        assertFalse(service.check(user1, () -> { return correctPassword; }));
        assertFalse(service.check(user1, () -> { return wrongPassword; }));
        assertFalse(service.check(user1, () -> { return correctVerificationCode; }));
        assertFalse(service.check(user1, () -> { return wrongVerificationCode; }));

        assertTrue(service.check(user2, () -> { return correctPassword; }));
        assertFalse(service.check(user2, () -> { return wrongPassword; }));
        assertFalse(service.check(user2, () -> { return correctVerificationCode; }));
        assertFalse(service.check(user2, () -> { return wrongVerificationCode; }));

        assertTrue(service.check(user3, () -> { return correctVerificationCode; }));
        assertFalse(service.check(user3, () -> { return wrongVerificationCode; }));
        assertFalse(service.check(user3, () -> { return correctPassword; }));
        assertFalse(service.check(user3, () -> { return wrongPassword; }));
    }

    void check3(CheckServiceImpl service) {
        assertFalse(service.check(user1.getCertificate(), correctPassword));
        assertFalse(service.check(user1.getCertificate(), wrongPassword));
        assertFalse(service.check(user1.getCertificate(), correctVerificationCode));
        assertFalse(service.check(user1.getCertificate(), wrongVerificationCode));

        assertTrue(service.check(user2.getCertificate(), correctPassword));
        assertFalse(service.check(user2.getCertificate(), wrongPassword));
        assertFalse(service.check(user2.getCertificate(), correctVerificationCode));
        assertFalse(service.check(user2.getCertificate(), wrongVerificationCode));

        assertTrue(service.check(user3.getCertificate(), correctVerificationCode));
        assertFalse(service.check(user3.getCertificate(), wrongVerificationCode));
        assertFalse(service.check(user3.getCertificate(), correctPassword));
        assertFalse(service.check(user3.getCertificate(), wrongPassword));
    }

    void check4(CheckServiceImpl service) {
        assertFalse(service.check(user1.getCertificate(), () -> { return correctPassword; }));
        assertFalse(service.check(user1.getCertificate(), () -> { return wrongPassword; }));
        assertFalse(service.check(user1.getCertificate(), () -> { return correctVerificationCode; }));
        assertFalse(service.check(user1.getCertificate(), () -> { return wrongVerificationCode; }));

        assertTrue(service.check(user2.getCertificate(), () -> { return correctPassword; }));
        assertFalse(service.check(user2.getCertificate(), () -> { return wrongPassword; }));
        assertFalse(service.check(user2.getCertificate(), () -> { return correctVerificationCode; }));
        assertFalse(service.check(user2.getCertificate(), () -> { return wrongVerificationCode; }));

        assertTrue(service.check(user3.getCertificate(), () -> { return correctVerificationCode; }));
        assertFalse(service.check(user3.getCertificate(), () -> { return wrongVerificationCode; }));
        assertFalse(service.check(user3.getCertificate(), () -> { return correctPassword; }));
        assertFalse(service.check(user3.getCertificate(), () -> { return wrongPassword; }));
    }

}