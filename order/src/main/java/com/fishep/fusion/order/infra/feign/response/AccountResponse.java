package com.fishep.fusion.order.infra.feign.response;

import lombok.Data;

@Data
public class AccountResponse {

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
