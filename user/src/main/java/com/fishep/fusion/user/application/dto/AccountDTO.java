package com.fishep.fusion.user.application.dto;

import lombok.Data;

@Data
public class AccountDTO {

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
