package com.fishep.fusion.user.interfaces.response;

import lombok.Data;

@Data
public class UserLoginResponse {

    public Long id;

    public String name;

    public String email;

    public String createdAt;

    public String updatedAt;

    public String token;

}
