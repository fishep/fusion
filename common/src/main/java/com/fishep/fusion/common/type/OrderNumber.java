package com.fishep.fusion.common.type;

public class OrderNumber extends AbstractNumber {
    public OrderNumber(String value) {
        super(value);
    }

    public OrderNumber() {
    }

    @Override
    protected String prefix() {
        return prefix = "OR";
    }
}
