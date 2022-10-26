package com.fishep.fusion.user.interfaces.response;

import lombok.Data;

@Data
public class UserLoginResponse {

    @Data
    public class User {
        public Long id;

        public String name;

        public String email;

        public String createdAt;

        public String updatedAt;
    }

    @Data
    public class Token {
        public String accessToken;

        public String tokenType;

        public Integer expiresIn;
    }

    public User user;

    public Token token;

    public UserLoginResponse() {
        this.user = new User();
        this.token = new Token();
    }

}
