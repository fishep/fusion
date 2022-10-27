package com.fishep.fusion.user.application.cqe;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class UserQueryCommand {

    @NotNull
    public Long id;

}
