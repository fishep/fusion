package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Password;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/3/31 18:06
 * @Desc
 **/
@Data
public class RegisterWithVerifyCmd {

    public App app;

    public Account account;

    public Password password;

    public VerificationCode verificationCode;

}
