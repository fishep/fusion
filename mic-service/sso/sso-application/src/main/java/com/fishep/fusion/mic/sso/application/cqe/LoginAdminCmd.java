package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.User;

/**
 * @Author fly.fei
 * @Date 2024/12/18 18:20
 * @Desc
 **/
public class LoginAdminCmd extends LoginCmd {

    @Override
    public <T extends User> Class<T> getUserType() {
        return null;
    }

}
