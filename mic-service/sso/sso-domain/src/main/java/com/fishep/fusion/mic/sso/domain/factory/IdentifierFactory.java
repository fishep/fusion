package com.fishep.fusion.mic.sso.domain.factory;

import cn.hutool.core.util.StrUtil;
import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.type.Email;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import com.fishep.fusion.mic.sso.domain.type.PhoneNumber;
import com.fishep.fusion.mic.sso.domain.type.UserName;

/**
 * @Author fly.fei
 * @Date 2024/12/31 11:02
 * @Desc
 **/
public class IdentifierFactory {

    public static Identifier create(String identifier) {
        if (!StrUtil.isBlank(identifier)) {
            if (identifier.matches(UserName.regex)) {
                return new UserName(identifier);
            }

            if (identifier.matches(Email.regex)) {
                return new Email(identifier);
            }

            if (identifier.matches(PhoneNumber.regex)) {
                return new PhoneNumber(identifier);
            }
        }

        throw new ValidateException("Unsupported identifier types, identifier: {}", identifier);
    }

}
