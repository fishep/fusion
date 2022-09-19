package com.fishep.fusion.common.util.impl;

import org.springframework.stereotype.Component;

@Component("order")
public class OrderNumber extends AbstractNumber {
    @Override
    protected String prefix() {
        return "OD";
    }

    @Override
    protected Integer length() {
        return Integer.valueOf(16);
    }
}
