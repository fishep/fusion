package com.fishep.fusion.common.rpc.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountResponse implements Serializable {

    public Long id;

    public String number;

    public Long userId;

    public String name;

    public String currency;

    public Integer amount;

    public Integer quota;

    public String createdAt;

    public String updatedAt;

}
