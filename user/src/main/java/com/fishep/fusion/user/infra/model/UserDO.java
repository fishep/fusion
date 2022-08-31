package com.fishep.fusion.user.infra.model;

import lombok.Data;

@Data
public class UserDO {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Long createdAt;

    private Long updatedAt;

}
