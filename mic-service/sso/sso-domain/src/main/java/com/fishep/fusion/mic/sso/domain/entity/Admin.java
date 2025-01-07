package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author fly.fei
 * @Date 2024/12/4 17:10
 * @Desc 管理员
 **/
@Getter
@Setter
public class Admin extends User {

    private UserName userName;

    private Email email;

    private PhoneNumber phoneNumber;

    // 其他属性


    public Admin() {
        super(new AdminId());
    }

    public Admin(AdminId adminId) {
        super(adminId);
    }

    public Admin(AdminId adminId, Identifier identifier) {
        super(adminId, identifier);
    }

}
