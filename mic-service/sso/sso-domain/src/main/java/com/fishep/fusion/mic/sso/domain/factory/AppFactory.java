package com.fishep.fusion.mic.sso.domain.factory;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Back;
import com.fishep.fusion.mic.sso.domain.type.Mall;
import com.fishep.fusion.mic.sso.domain.type.Open;

/**
 * @Author fly.fei
 * @Date 2024/12/31 11:26
 * @Desc
 **/
public class AppFactory {

    public static App create(String app) {
        if ("back".equalsIgnoreCase(app)) {
            return new Back();
        }

        if ("mall".equalsIgnoreCase(app)) {
            return new Mall();
        }

        if ("open".equalsIgnoreCase(app)) {
            return new Open();
        }

        throw new ValidateException("Unsupported App types, app: {}", app);
    }

}
