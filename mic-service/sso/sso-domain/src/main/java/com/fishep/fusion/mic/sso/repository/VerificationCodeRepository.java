package com.fishep.fusion.mic.sso.repository;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.VerificationCode;

/**
 * @Author fly.fei
 * @Date 2025/4/3 17:26
 * @Desc
 **/
public interface VerificationCodeRepository {

    VerificationCode findOrException(App app, Account account);

}
