package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.ddd.domain.type.Id;
import com.fishep.fusion.mic.sso.domain.service.BindService;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2024/12/4 17:07
 * @Desc 表示一个用户
 **/
@Getter
public abstract class User {

    //    id 唯一id
    protected Id id;

    protected Account account;

    protected User(Id id) {
        if (id == null) {
            throw new ValidateException("The User Id is null");
        }

        this.id = id;
    }

    public void bindAccount(Account account, BindService bindService) {
        if (bindService.canUse(this, account)) {
            this.account = account;
            return;
        }

        throw new ValidateException("Unsupported bindAccount");
    }

}
