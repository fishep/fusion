package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.AdminId;

/**
 * @Author fly.fei
 * @Date 2024/12/4 17:10
 * @Desc 管理员
 **/

public class Admin extends User {

    // 其他属性
    private Object field;

    public Admin(AdminId adminId) {
        super(adminId);
    }

}
