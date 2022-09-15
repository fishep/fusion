package com.fishep.fusion.user.application.cqe;

import com.fishep.fusion.common.type.Email;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserEmailLoginCommand {

    @NotNull(message = "user login email is null")
    Email userEmail;

    @NotNull
    String password;

}
