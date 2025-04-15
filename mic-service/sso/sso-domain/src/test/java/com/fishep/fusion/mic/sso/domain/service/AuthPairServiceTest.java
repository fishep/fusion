package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.UserFactory;
import com.fishep.fusion.mic.sso.domain.service.impl.AuthPairServiceImpl;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author fly.fei
 * @Date 2024/12/28 10:22
 * @Desc
 **/
class AuthPairServiceTest {

    private static Identifier userName = new UserName("test.test");
    private static Identifier email = new Email("test@email.com");
    private static Identifier phoneNumber = new PhoneNumber("11111111111");

    private static CertificateHashService hashService = new CertificateHashServiceImpl();
    private static Certificate password = new Password("12345678", hashService);
    private static Certificate verificationCode = new VerificationCode("123456", hashService);

    private static User admin = UserFactory.createAdmin();
    private static User customer = UserFactory.createCustomer();

    @Test
    void testAuthPairServiceImpl() {
        BindService authPairService = new AuthPairServiceImpl();
        canUse(authPairService);
    }

    /**
     * 业务设定，想咋改咋改
     * <p>
     * 用户类型            认证方式
     * 管理员 Admin        用户名和密码
     * 客户 Customer       邮箱和密码 || 邮箱和验证码 || 手机号和密码 || 手机号和验证码
     * 。。。
     */
    void canUse(BindService service) {
        assertFalse(service.canUse(null, null, null));
        assertFalse(service.canUse(null, userName, password));
        assertFalse(service.canUse(admin, null, password));
        assertFalse(service.canUse(admin, userName, null));

        assertTrue(service.canUse(admin, userName, password));
        assertFalse(service.canUse(admin, email, password));
        assertFalse(service.canUse(admin, phoneNumber, password));
        assertFalse(service.canUse(admin, userName, verificationCode));
        assertFalse(service.canUse(admin, email, verificationCode));
        assertFalse(service.canUse(admin, phoneNumber, verificationCode));

        assertFalse(service.canUse(customer, userName, password));
        assertTrue(service.canUse(customer, email, password));
        assertTrue(service.canUse(customer, phoneNumber, password));
        assertFalse(service.canUse(customer, userName, verificationCode));
        assertTrue(service.canUse(customer, email, verificationCode));
        assertTrue(service.canUse(customer, phoneNumber, verificationCode));
    }

}