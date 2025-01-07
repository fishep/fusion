package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;

/**
 * @Author fly.fei
 * @Date 2024/12/20 10:04
 * @Desc
 **/
public class UserName extends Identifier {

    public static String regex = "^[a-z]+(\\.[a-z]+)*$";

    public UserName(String value) {
        super(value);

        if (!this.value.matches(regex)) {
            throw new ValidateException("The username({}) does not comply with the specifications", value);
        }
    }
}
