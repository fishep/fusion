package com.fishep.fusion.common.type;

import com.fishep.fusion.common.exception.EmailPatternException;
import lombok.Data;

@Data
public class Email {
    private String value;

    public Email(String value) {

        if (!value.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")){
            throw new EmailPatternException("email: " + value + ", Not a correct email format");
        }

        this.value = value;
    }

}
