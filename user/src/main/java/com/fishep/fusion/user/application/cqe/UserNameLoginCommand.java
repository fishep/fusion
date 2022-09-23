package com.fishep.fusion.user.application.cqe;

import com.fishep.fusion.common.type.UserName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNameLoginCommand {

    @NotNull
    UserName userName;

    @NotNull
    String password;

}
