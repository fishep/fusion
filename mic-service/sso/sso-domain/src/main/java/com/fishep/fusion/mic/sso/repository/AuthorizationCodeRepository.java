package com.fishep.fusion.mic.sso.repository;

import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.AuthorizationCode;

/**
 * @Author fly.fei
 * @Date 2025/4/2 12:02
 * @Desc
 **/
public interface AuthorizationCodeRepository {

    AuthorizationCode findOrException(App app, AuthorizationCode authorizationCode);

    void saveOrException(App app, AuthorizationCode code);

}
