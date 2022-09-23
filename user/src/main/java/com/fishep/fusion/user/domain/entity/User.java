package com.fishep.fusion.user.domain.entity;

import com.fishep.fusion.common.type.Email;
import com.fishep.fusion.common.type.UserId;
import com.fishep.fusion.common.type.UserName;
import lombok.Data;

import java.time.Instant;

@Data
public class User {

    private UserId id;

    private UserName name;

    private Email email;

    private String passwordHash;

    private Instant createdAt;

    private Instant updatedAt;

}
