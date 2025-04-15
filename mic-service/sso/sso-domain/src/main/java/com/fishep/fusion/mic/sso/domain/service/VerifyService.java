package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.type.VerificationCode;

/**
 * @Author fly.fei
 * @Date 2024/12/26 17:43
 * @Desc
 **/
public interface VerifyService {

    boolean verify(VerificationCode vCode1, VerificationCode vCode2);

    void assertVerifySuccess(VerificationCode vCode1, VerificationCode vCode2) throws RuntimeException;

}
