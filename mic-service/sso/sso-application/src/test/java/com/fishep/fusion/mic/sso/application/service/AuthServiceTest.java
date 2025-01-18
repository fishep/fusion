package com.fishep.fusion.mic.sso.application.service;

import com.fishep.fusion.mic.sso.application.cqe.RegisterAdminCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterCustomerCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterSupplierCmd;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @Author fly.fei
 * @Date 2025/1/8 12:25
 * @Desc
 **/
class AuthServiceTest {

    @Test
    void register() {
    }

    @Test
    void sendVerificationCodeCmd() {
    }

    @Test
    void activate() {
    }

    @Test
    void login() {
    }

    void testRegister(AuthService service) {
        assertDoesNotThrow(() -> { service.register(new RegisterAdminCmd()); });
        assertDoesNotThrow(() -> { service.register(new RegisterCustomerCmd()); });
        assertDoesNotThrow(() -> { service.register(new RegisterSupplierCmd()); });
    }

    void testSendVerificationCodeCmd(AuthService service) {
//        service.sendVerificationCodeCmd()
    }

    void testActivate(AuthService service) {
    }

    void testLogin(AuthService service) {
    }

//    @Test
//    void testAuthServiceLooseImpl(AuthService service, String identifier, String password) {
//        AuthService service = new AuthServiceLooseImpl();
//
//
//        new RegisterAdminCmd()
//
//    }
//
//
//    void looseProcess(AuthService service, RegisterCmd registerCmd,) {
//
//
//
//        service.register(registerCmd);
//
//        service.sendVerificationCodeCmd(new SendVerificationCodeCmd());
//
//        service.login(new LoginAdminCmd());
//    }
//
//    @Test
//    void testAuthServiceStrictImpl() {
//    }
//
//    @Test
//    void testAuthServiceDelayImpl() {
//    }
}