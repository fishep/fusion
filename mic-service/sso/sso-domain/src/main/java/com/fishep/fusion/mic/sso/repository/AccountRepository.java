package com.fishep.fusion.mic.sso.repository;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.type.Identifier;

/**
 * @Author fly.fei
 * @Date 2024/12/26 10:57
 * @Desc
 **/
public interface AccountRepository {

    void saveOrException(Account account);

    <T extends Account> void assertNotExist(Identifier identifier, Class<T> userClass);

}
