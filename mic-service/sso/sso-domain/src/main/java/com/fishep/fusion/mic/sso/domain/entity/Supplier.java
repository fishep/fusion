package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author fly.fei
 * @Date 2024/12/4 17:13
 * @Desc 供应商
 **/
@Getter
@Setter
public class Supplier extends User {

    private UserName userName;

    private Email email;

    private PhoneNumber phoneNumber;

    // 其他属性


    public Supplier() {
        super(new SupplierId());
    }

    public Supplier(SupplierId supplierId) {
        super(supplierId);
    }

    public Supplier(SupplierId supplierId, Identifier identifier) {
        super(supplierId, identifier);
    }

}
