package com.fishep.fusion.mic.sso.repository;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.ActivateCode;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Identifier;

/**
 * @Author fly.fei
 * @Date 2025/4/3 18:18
 * @Desc
 **/
public interface ActivateCodeRepository {

    void saveOrException(String app, String user, Identifier identifier, ActivateCode code);

    void findOrException(String app, String user, Identifier identifier);

}
