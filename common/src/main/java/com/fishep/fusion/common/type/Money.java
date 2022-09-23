package com.fishep.fusion.common.type;

public class Money {

    private Currency currency;

    private Integer value; // 单位：分

    public Money(Currency currency, Integer value) {
        this.currency = currency;
        this.value = value;
    }

    public Money(String code, Integer value) {
        this.currency = new Currency(code);
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Money plus(Money money){
        if (currency.getCode() != money.getCurrency().getCode()){
            throw new RuntimeException("Different currencies cannot be added, currency: " + currency + ", plus currency: " + money.getCurrency());
        }

        value += money.getValue();

        return this;
    }

    public Money minus(Money money){
        if (currency.getCode() != money.getCurrency().getCode()){
            throw new RuntimeException("Different currencies cannot be subtracted, currency: " + currency + ", minus currency: " + money.getCurrency());
        }

        value -= money.getValue();

        return this;
    }
}
