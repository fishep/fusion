package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.AdminId;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author fly.fei
 * @Date 2024/12/4 17:10
 * @Desc 管理员
 **/
public class Admin extends User {

    // 其他属性
    @Getter
    @Setter
    private Object field;


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
