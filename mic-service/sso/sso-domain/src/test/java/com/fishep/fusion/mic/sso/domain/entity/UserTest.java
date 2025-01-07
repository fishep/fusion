package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.service.impl.AuthPairServiceImpl;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2024/12/26 14:17
 * @Desc
 **/
class UserTest {

    private static Identifier userName = new UserName("test.test");
    private static Identifier email = new Email("test@email.com");
    private static Identifier phoneNumber = new PhoneNumber("11111111111");

    private static CertificateHashService hashService = new CertificateHashServiceImpl();
    private static Certificate password = new Password("12345678", hashService);
    private static Certificate verificationCode = new VerificationCode("123456", hashService);

    private static AuthPairService authPairService = new AuthPairServiceImpl();

    @Test
    void create() {
        assertThrows(ValidateException.class, () -> { new Admin(null); });
        assertDoesNotThrow(() -> { new Admin(new AdminId()); });

        assertThrows(ValidateException.class, () -> { new Admin(null, null); });
        assertThrows(ValidateException.class, () -> { new Admin(new AdminId(), null); });
        assertThrows(ValidateException.class, () -> { new Admin(null, new UserName("test")); });
        assertDoesNotThrow(() -> { new Admin(new AdminId(), new UserName("test")); });
    }

    @Test
    void testAuthPair() {
        testAdminAuthPair();
        testCustomerAuthPair();
    }

    /**
     * 业务设定，想咋改咋改
     * <p>
     * 用户类型            认证方式
     * 管理员 Admin        用户名和密码
     * 客户 Customer       邮箱和密码 || 手机号和密码 || 手机号和验证码
     * 。。。
     */
    void testAdminAuthPair() {
        assertDoesNotThrow(() -> { new Admin(new AdminId(), new UserName("test")); });
        User admin = new Admin(new AdminId(), new UserName("test"));

        assertDoesNotThrow(() -> { admin.setAuthPair(password, authPairService); });
        assertNotNull(admin.getIdentifier());
        assertNotNull(admin.getCertificate());

        assertThrows(ValidateException.class, () -> { admin.setAuthPair(verificationCode, authPairService); });
    }

    void testCustomerAuthPair() {
        User customer = new Customer();

        assertThrows(ValidateException.class, () -> { customer.setAuthPair(userName, password, authPairService); });
        assertThrows(ValidateException.class, () -> { customer.setAuthPair(userName, verificationCode, authPairService); });

        assertDoesNotThrow(() -> { customer.setAuthPair(email, password, authPairService); });
        assertNotNull(customer.getIdentifier());
        assertNotNull(customer.getCertificate());
        assertDoesNotThrow(() -> { customer.setAuthPair(email, verificationCode, authPairService); });

        assertDoesNotThrow(() -> { customer.setAuthPair(phoneNumber, password, authPairService); });
        assertDoesNotThrow(() -> { customer.setAuthPair(phoneNumber, verificationCode, authPairService); });
    }

}