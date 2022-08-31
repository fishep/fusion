package com.fishep.fusion.user.common.type;

import lombok.Data;

@Data
public class UserName {
    private String value;

    public UserName(String value) {
        this.match(value);

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.match(value);

        this.value = value;
    }

    private void match(String value) {
        if (!value.matches("^[\\w\\-]+(\\.[\\w\\-]+)*$")) {
            throw new IllegalArgumentException("用户名: " + value + ", 格式不正确, 包含大小写字母中划线下划线点组成的字符");
        }
    }

}
