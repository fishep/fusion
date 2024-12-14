package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.sso.domain.entity.*;
import com.fishep.fusion.mic.sso.domain.service.GuardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author fly.fei
 * @Date 2024/12/14 11:59
 * @Desc
 **/
class GuardServiceImplTest {

    @Test
    void canAccessUseGuardServiceImpl() {
        /**
         * 业务设定
         * 后台访问策略，只允许Admin管理员访问
         * 商城访问策略，允许Customer客户访问，允许Admin管理员访问，允许Supplier供应商访问
         * 开放访问策略，只允许以应用的身份访问
         */
        GuardService guardService = new GuardServiceImpl();
        assertTrue(guardService.canAccess(new Admin(), new Back()));
        assertFalse(guardService.canAccess(new Customer(), new Back()));
        assertFalse(guardService.canAccess(new Supplier(), new Back()));
        assertTrue(guardService.canAccess(new Admin(), new Mall()));
        assertTrue(guardService.canAccess(new Customer(), new Mall()));
        assertTrue(guardService.canAccess(new Supplier(), new Mall()));
        assertFalse(guardService.canAccess(new Admin(), new Open()));
        assertFalse(guardService.canAccess(new Customer(), new Open()));
        assertFalse(guardService.canAccess(new Supplier(), new Open()));

        assertFalse(guardService.canAccess(null, null));
        assertFalse(guardService.canAccess(new Admin(), null));
        assertFalse(guardService.canAccess(null, new Back()));
    }

    @Test
    void canAccessUseGuardServiceGenericImpl() {
        /**
         * 业务设定
         * 后台访问策略，只允许Admin管理员访问
         * 商城访问策略，允许Customer客户访问，允许Admin管理员访问，允许Supplier供应商访问
         * 开放访问策略，只允许以应用的身份访问
         */
        GuardService guardService = new GuardServiceGenericImpl();
        assertTrue(guardService.canAccess(new Admin(), new Back()));
        assertFalse(guardService.canAccess(new Customer(), new Back()));
        assertFalse(guardService.canAccess(new Supplier(), new Back()));
        assertTrue(guardService.canAccess(new Admin(), new Mall()));
        assertTrue(guardService.canAccess(new Customer(), new Mall()));
        assertTrue(guardService.canAccess(new Supplier(), new Mall()));
        assertFalse(guardService.canAccess(new Admin(), new Open()));
        assertFalse(guardService.canAccess(new Customer(), new Open()));
        assertFalse(guardService.canAccess(new Supplier(), new Open()));

        assertFalse(guardService.canAccess(null, null));
        assertFalse(guardService.canAccess(new Admin(), null));
        assertFalse(guardService.canAccess(null, new Back()));
    }

}