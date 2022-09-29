package com.fishep.fusion.user.application.cqe;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Money;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class AccountUpdateCommand {

    @NotNull
    public AccountId accountId;

    @NotNull
    public Money accountAmount;

}
