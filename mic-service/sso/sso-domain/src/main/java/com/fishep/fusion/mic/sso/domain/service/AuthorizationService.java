package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.type.AuthorizationCode;

/**
 * @Author fly.fei
 * @Date 2025/4/2 11:54
 * @Desc
 **/
public interface AuthorizationService {

    boolean apply(Account account, AuthorizationCode authorizationCode);

    void assertApplySuccess(Account account, AuthorizationCode authorizationCode) throws RuntimeException;

}
