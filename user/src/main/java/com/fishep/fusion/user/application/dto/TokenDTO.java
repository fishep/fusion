package com.fishep.fusion.user.application.dto;

import lombok.Data;

@Data
public class TokenDTO {

    public String accessToken;

    public String tokenType;

    public Integer expiresIn;

}
