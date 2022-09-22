package com.fishep.fusion.common.type;

import lombok.Data;

@Data
public class Currency {

    public enum Code {
        CNY, USD
    }

    private Code code;

    public Currency(Code code) {
        this.code = code;
    }

    public Currency(String code) {
        this.code = Code.valueOf(code);
    }

    public String getCodeName()
    {
        return this.code.name();
    }

    public void setByCodeName(String code)
    {
        this.code = Code.valueOf(code);
    }

}
