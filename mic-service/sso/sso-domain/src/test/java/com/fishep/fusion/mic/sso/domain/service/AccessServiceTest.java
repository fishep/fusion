package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.UserFactory;
import com.fishep.fusion.mic.sso.domain.service.impl.AccessServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Back;
import com.fishep.fusion.mic.sso.domain.type.Mall;
import com.fishep.fusion.mic.sso.domain.type.Open;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author fly.fei
 * @Date 2024/12/28 10:22
 * @Desc
 **/
class AccessServiceTest {

    private static User admin = UserFactory.createAdmin();
    private static User customer = UserFactory.createCustomer();
    private static User supplier = UserFactory.createSupplier();

    private static App back = new Back();
    private static App mall = new Mall();
    private static App open = new Open();

    @Test
    void testAccessServiceImpl() {
        AccessService accessService = new AccessServiceImpl();
        canAccess(accessService);
    }

//    @Test
//    void testAccessServiceOtherImpl() {
//        AccessService accessService = new AccessServiceOtherImpl();
//        canAccess(accessService);
//    }

    /**
     * 业务设定，想咋改咋改
     * 后台访问策略，只允许Admin管理员访问
     * 商城访问策略，允许Customer客户访问，允许Admin管理员访问
     * 开放访问策略，只允许以应用的身份访问
     */
    void canAccess(AccessService accessService) {
        assertFalse(accessService.canAccess(null, null));
        assertFalse(accessService.canAccess(admin, null));
        assertFalse(accessService.canAccess(null, back));

        assertTrue(accessService.canAccess(admin, back));
        assertFalse(accessService.canAccess(customer, back));
        assertFalse(accessService.canAccess(supplier, back));

        assertTrue(accessService.canAccess(admin, mall));
        assertTrue(accessService.canAccess(customer, mall));
        assertFalse(accessService.canAccess(supplier, mall));

        assertFalse(accessService.canAccess(admin, open));
        assertFalse(accessService.canAccess(customer, open));
        assertFalse(accessService.canAccess(supplier, open));
    }

}