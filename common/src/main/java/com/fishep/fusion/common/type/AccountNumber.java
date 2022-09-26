package com.fishep.fusion.common.type;

public class AccountNumber extends AbstractNumber{
    public AccountNumber(String value) {
        super(value);
    }

    public AccountNumber() {
    }

    @Override
    protected String prefix() {
        return prefix = "AC";
    }
}
