package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.sso.domain.type.SupplierId;

/**
 * @Author fly.fei
 * @Date 2024/12/4 17:13
 * @Desc 供应商
 **/
public class Supplier extends User {

    // 其他属性
    private Object field;

    public Supplier(SupplierId supplierId) {
        super(supplierId);
    }

}
