package com.fishep.fusion.mic.sso.domain.type;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2024/12/20 10:01
 * @Desc
 **/
@Getter
public class Email extends Identifier {

    //    public static String regex = "^[a-zA-Z]+(\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$";
    public static String regex = "[\\w.]+@[\\w.]+";

    protected String prefix;

    protected String suffix;

    public Email(String value) {
        super(value);

        if (!this.value.matches(regex)) {
            throw new ValidateException("The email({}) does not comply with the specifications", value);
        }

        parse();
    }

    protected void parse() {
        String[] split = value.split("@", 2);
        prefix = split[0];
        suffix = split[1];
    }

}
