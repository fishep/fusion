package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.Admin;
import com.fishep.fusion.mic.sso.domain.entity.Customer;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.UserFactory;
import com.fishep.fusion.mic.sso.domain.service.impl.AuthPairServiceImpl;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import com.fishep.fusion.mic.sso.domain.service.impl.VerifyServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author fly.fei
 * @Date 2024/12/28 10:23
 * @Desc
 **/
class VerifyServiceTest {
    private static BindService authPairService = new AuthPairServiceImpl();
    private static CertificateHashService hashService = new CertificateHashServiceImpl();

    private static User user0; // 没有标识
    private static User user1; // 用户名标识 没有凭证
    private static User user2; // 邮箱标识 验证码凭证
    private static User user3; // 手机号标识 验证码凭证
    private static User user4; // 手机号标识 没有凭证

    private static Certificate correctPassword = new Password("12345678", hashService);
    private static Certificate wrongPassword = new Password("87654321", hashService);
    private static Certificate correctVerificationCode = new VerificationCode("123456", hashService);
    private static Certificate wrongVerificationCode = new VerificationCode("654321", hashService);

    static {
        user0 = new Admin(new AdminId());
        user1 = new Admin(new AdminId(), new UserName("test.test"));
        user2 = UserFactory.createCustomer();
        user2.setAuthPair(new Email("test@email.com"), new VerificationCode("123456", hashService), authPairService);
        user3 = UserFactory.createCustomer();
        user3.setAuthPair(new PhoneNumber("11111111111"), new VerificationCode("123456", hashService), authPairService);
        user4 = new Customer(new CustomerId(), new PhoneNumber("11111111111"));
    }

    @Test
    void testVerifyServiceImpl() {
        VerifyService service = new VerifyServiceImpl();
        verify1(service);
        verify2(service);
    }

    /**
     * 业务设定
     * <p>
     * 用户名: 注册就归其所有，不用验证
     * 邮箱：验证码验证通过则证明为其所有
     * 手机号: 验证码验证通过则证明为其所有
     */
    void verify1(VerifyService service) {
        assertFalse(service.verify(null, correctPassword));
        assertFalse(service.verify(null, correctVerificationCode));

        assertFalse(service.verify(user0, correctPassword));
        assertFalse(service.verify(user0, wrongPassword));
        assertFalse(service.verify(user0, correctVerificationCode));
        assertFalse(service.verify(user0, wrongVerificationCode));

        assertTrue(service.verify(user1, correctPassword));
        assertTrue(service.verify(user1, wrongPassword));
        assertTrue(service.verify(user1, correctVerificationCode));
        assertTrue(service.verify(user1, wrongVerificationCode));

        assertFalse(service.verify(user2, correctPassword));
        assertFalse(service.verify(user2, wrongPassword));
        assertTrue(service.verify(user2, correctVerificationCode));
        assertFalse(service.verify(user2, wrongVerificationCode));

        assertFalse(service.verify(user3, correctPassword));
        assertFalse(service.verify(user3, wrongPassword));
        assertTrue(service.verify(user3, correctVerificationCode));
        assertFalse(service.verify(user3, wrongVerificationCode));

        assertFalse(service.verify(user4, correctPassword));
        assertFalse(service.verify(user4, wrongPassword));
        assertFalse(service.verify(user4, correctVerificationCode));
        assertFalse(service.verify(user4, wrongVerificationCode));
    }

    void verify2(VerifyService service) {
        assertFalse(service.verify(null, () -> { return correctPassword; }));
        assertFalse(service.verify(null, () -> { return correctVerificationCode; }));

        assertFalse(service.verify(user0, () -> { return null; }));
        assertFalse(service.verify(user0, () -> { return correctPassword; }));
        assertFalse(service.verify(user0, () -> { return wrongPassword; }));
        assertFalse(service.verify(user0, () -> { return correctVerificationCode; }));
        assertFalse(service.verify(user0, () -> { return wrongVerificationCode; }));

        assertTrue(service.verify(user1, () -> { return null; }));
        assertTrue(service.verify(user1, () -> { return correctPassword; }));
        assertTrue(service.verify(user1, () -> { return wrongPassword; }));
        assertTrue(service.verify(user1, () -> { return correctVerificationCode; }));
        assertTrue(service.verify(user1, () -> { return wrongVerificationCode; }));

        assertFalse(service.verify(user2, () -> { return null; }));
        assertFalse(service.verify(user2, () -> { return correctPassword; }));
        assertFalse(service.verify(user2, () -> { return wrongPassword; }));
        assertTrue(service.verify(user2, () -> { return correctVerificationCode; }));
        assertFalse(service.verify(user2, () -> { return wrongVerificationCode; }));

        assertFalse(service.verify(user3, () -> { return null; }));
        assertFalse(service.verify(user3, () -> { return correctPassword; }));
        assertFalse(service.verify(user3, () -> { return wrongPassword; }));
        assertTrue(service.verify(user3, () -> { return correctVerificationCode; }));
        assertFalse(service.verify(user3, () -> { return wrongVerificationCode; }));

        assertFalse(service.verify(user4, () -> { return null; }));
        assertFalse(service.verify(user4, () -> { return correctPassword; }));
        assertFalse(service.verify(user4, () -> { return wrongPassword; }));
        assertFalse(service.verify(user4, () -> { return correctVerificationCode; }));
        assertFalse(service.verify(user4, () -> { return wrongVerificationCode; }));
    }

}