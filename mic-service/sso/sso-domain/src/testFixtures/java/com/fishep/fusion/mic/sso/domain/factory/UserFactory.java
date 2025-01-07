package com.fishep.fusion.mic.sso.domain.factory;

import com.fishep.fusion.mic.sso.domain.entity.Admin;
import com.fishep.fusion.mic.sso.domain.entity.Customer;
import com.fishep.fusion.mic.sso.domain.entity.Supplier;
import com.fishep.fusion.mic.sso.domain.service.impl.CertificateHashServiceImpl;
import com.fishep.fusion.mic.sso.domain.type.*;

/**
 * @Author fly.fei
 * @Date 2024/12/23 16:20
 * @Desc
 **/
public class UserFactory {

    private static UserName userName = new UserName("test.test");
    private static Email email = new Email("test@email.com");
    private static PhoneNumber phoneNumber = new PhoneNumber("11111111111");

    private static CertificateHashServiceImpl hashService = new CertificateHashServiceImpl();
    private static Password password = new Password("12345678", hashService);
    private static VerificationCode verificationCode = new VerificationCode("123456", hashService);

    public static Admin createAdmin() {
        Admin admin = new Admin();
//        admin.setUserName(userName);
//        admin.setEmail(email);
//        admin.setPhoneNumber(phoneNumber);

        return admin;
    }

    public static Customer createCustomer() {
        Customer customer = new Customer();
//        customer.setUserName(userName);
//        customer.setEmail(email);
//        customer.setPhoneNumber(phoneNumber);

        return customer;
    }

    public static Supplier createSupplier() {
        Supplier supplier = new Supplier();
//        supplier.setUserName(userName);
//        supplier.setEmail(email);
//        supplier.setPhoneNumber(phoneNumber);

        return supplier;
    }

}
