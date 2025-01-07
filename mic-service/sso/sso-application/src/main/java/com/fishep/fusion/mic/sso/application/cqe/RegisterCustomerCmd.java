package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @Author fly.fei
 * @Date 2024/12/26 10:31
 * @Desc
 **/
public class RegisterCustomerCmd extends RegisterCmd {

    @Email
    public String email;

    @NotBlank
    public String phoneNumber;

    @Size(min = 8, max = 32)
    public String password;

    @Size(min = 6, max = 6)
    public String verificationCode;

    @Override
    public User getUser(AuthPairService authPairService, CertificateHashService certificateHashService) {
        return null;
    }

}
