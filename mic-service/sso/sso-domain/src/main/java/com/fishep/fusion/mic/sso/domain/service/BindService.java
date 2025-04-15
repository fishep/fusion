package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.Certificate;

/**
 * @Author fly.fei
 * @Date 2024/12/19 16:18
 * @Desc
 **/
public interface BindService {

    boolean canUse(Account account, Certificate certificate);

    boolean assertCanUse(Account account, Certificate certificate) throws RuntimeException;

    boolean canUse(User user, Account account);

    boolean assertCanUse(User user, Account account) throws RuntimeException;

}
