package com.fishep.fusion.user.infra.model;

import lombok.Data;

@Data
public class AccountDO {

    public Long id;

    public String number;

    public Long userId;

    public String name;

    public String currency;

    public Integer amount;

    public Integer quota;

    public Long createdAt;

    public Long updatedAt;

}
