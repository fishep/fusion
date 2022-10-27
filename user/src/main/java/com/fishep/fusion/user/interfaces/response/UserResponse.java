package com.fishep.fusion.user.interfaces.response;

import lombok.Data;

@Data
public class UserResponse {

    public Long id;

    public String name;

    public String email;

    public String createdAt;

    public String updatedAt;

}
