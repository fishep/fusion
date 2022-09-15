package com.fishep.fusion.user.interfaces.request;

import com.fishep.fusion.common.exception.EmailPatternException;
import lombok.Data;

@Data
public class UserLoginRequest {

    // 支持用户名 邮箱登陆
    public String identify;

    public String password;

    public String determineNameOrEmail(){

        if (identify.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")){
            return "email";
        }

        if (identify.matches("^[\\w\\-]+(\\.[\\w\\-]+)*$")) {
            return "name";
        }

        throw new RuntimeException("email or name pattern error");
    }
}
