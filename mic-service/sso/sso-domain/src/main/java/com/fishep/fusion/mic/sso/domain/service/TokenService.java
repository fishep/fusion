package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Token;

/**
 * @Author fly.fei
 * @Date 2025/4/2 11:39
 * @Desc
 **/
public interface TokenService {

    Token generate(User user, App app);

    User parse(Token token, App app);

}
