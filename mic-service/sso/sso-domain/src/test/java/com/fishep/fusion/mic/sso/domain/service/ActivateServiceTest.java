package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.Admin;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.UserFactory;
import com.fishep.fusion.mic.sso.domain.service.exception.CertificateException;
import com.fishep.fusion.mic.sso.domain.service.impl.ActivateServiceImpl;
import com.fishep.fusion.mic.sso.domain.service.impl.AuthPairServiceImpl;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author fly.fei
 * @Date 2025/1/6 17:48
 * @Desc
 **/
class ActivateServiceTest {

    private static AuthPairService authPairService = new AuthPairServiceImpl();
    private static CertificateHashService hashService = new CertificateHashServiceImpl();

    private static User user0; // 用户名+验证码，不符合条件
    private static User user1; // 邮箱+验证码，检查正确，激活
    private static User user2; // 手机号+验证码，检查正确，激活
    private static User user3; // 手机号+验证码，不正确正确，异常

    private static Certificate correctVerificationCode = new VerificationCode("123456", hashService);

    static {
        user0 = new Admin(new AdminId(), new UserName("test.test"));
        user1 = UserFactory.createCustomer();
        user1.setAuthPair(new Email("test@email.com"), new VerificationCode("123456", hashService), authPairService);
        user2 = UserFactory.createCustomer();
        user2.setAuthPair(new PhoneNumber("11111111111"), new VerificationCode("123456", hashService), authPairService);
        user3 = UserFactory.createCustomer();
        user3.setAuthPair(new PhoneNumber("11111111111"), new VerificationCode("654321", hashService), authPairService);
    }

    @Test
    void testActivateServiceImpl() {
        ActivateService service = new ActivateServiceImpl();
        activate1(service);
        activate2(service);
    }

    /**
     * 邮箱+验证码，检查正确，激活
     * 手机号+验证码，检查正确，激活
     * <p>
     * 不符合激活条件，不激活
     * 符合激活条件，激活用户: 修改用户状态
     * <p>
     * 没有返回值，验证码验证错误抛异常
     */
    void activate1(ActivateService service) {
        service.activate(user0, correctVerificationCode);
        assertNull(user0.getActivated());
        assertFalse(user0.isActivated());

        service.activate(user1, correctVerificationCode);
        assertTrue(user1.getActivated());

        service.activate(user2, correctVerificationCode);
        assertTrue(user2.getActivated());

        assertThrows(CertificateException.class, () -> {
            service.activate(user3, correctVerificationCode);
        });
    }

    void activate2(ActivateService service) {
        service.activate(user0, ()->{ return correctVerificationCode; });
        assertNull(user0.getActivated());
        assertFalse(user0.isActivated());

        service.activate(user1, ()->{ return correctVerificationCode; });
        assertTrue(user1.getActivated());

        service.activate(user2, ()->{ return correctVerificationCode; });
        assertTrue(user2.getActivated());

        assertThrows(CertificateException.class, () -> {
            service.activate(user3, ()->{ return correctVerificationCode; });
        });
    }

}