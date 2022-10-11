package com.fishep.fusion.common.rpc.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountUpdateRequest implements Serializable {

    public String currency;

    public Integer amount;

}
