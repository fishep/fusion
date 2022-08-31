package com.fishep.fusion.user.interfaces.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegisterRequest {

    public String name;

    public String email;

    public String password;

}
