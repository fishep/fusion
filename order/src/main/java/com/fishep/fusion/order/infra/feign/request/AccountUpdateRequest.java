package com.fishep.fusion.order.infra.feign.request;

import lombok.Data;

@Data
public class AccountUpdateRequest {

    public String currency;

    public Integer amount;

}
