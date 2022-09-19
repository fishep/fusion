package com.fishep.fusion.common.util.impl;

import org.springframework.stereotype.Component;

@Component("account")
public class AccountNumber extends AbstractNumber {
    @Override
    protected String prefix() {
        return "AC";
    }

    @Override
    protected Integer length() {
        return Integer.valueOf(16);
    }
}
