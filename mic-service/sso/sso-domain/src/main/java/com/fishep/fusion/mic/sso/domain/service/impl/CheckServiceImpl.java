package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.service.CheckService;
import com.fishep.fusion.mic.sso.domain.type.Certificate;

import java.util.function.Supplier;

/**
 * @Author fly.fei
 * @Date 2024/12/20 12:24
 * @Desc
 **/
public class CheckServiceImpl implements CheckService {

    @Override
    public boolean check(User user, Certificate certificate) {
        if (user == null || user.getCertificate() == null || certificate == null) {
            return false;
        }

        return user.getCertificate().equals(certificate);
    }

    @Override
    public boolean check(User user, Supplier<Certificate> supplier) {
        return check(user, supplier.get());
    }

    @Override
    public boolean check(Certificate certificate1, Certificate certificate2) {
        if (certificate1 == null || certificate2 == null) {
            return false;
        }

        return certificate1.equals(certificate2);
    }

    @Override
    public boolean check(Certificate certificate, Supplier<Certificate> supplier) {
        return check(certificate, supplier.get());
    }

}
