package com.fishep.fusion.user.common.type;

public class UserPassword {

    private String value;

    public UserPassword(String value) {
        if (value == null || value.length() < 8) {
            throw new IllegalArgumentException("密码长度要求8位及以上");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
