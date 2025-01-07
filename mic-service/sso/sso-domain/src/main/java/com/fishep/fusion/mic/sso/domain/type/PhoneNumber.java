package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;

/**
 * @Author fly.fei
 * @Date 2024/12/20 10:03
 * @Desc
 **/
public class PhoneNumber extends Identifier {

    public static String regex = "^[1-9]\\d{10}$";

    public PhoneNumber(String value) {
        super(value);

        if (!this.value.matches(regex)) {
            throw new ValidateException("The phone number({}) does not comply with the specifications", value);
        }
    }

}
