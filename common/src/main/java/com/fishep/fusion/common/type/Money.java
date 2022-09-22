package com.fishep.fusion.common.type;

public class Money {

    private Currency currency;

    private Integer amount; // 单位：分

    public Money(Currency currency, Integer amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money(String code, Integer amount) {
        this.currency = new Currency(code);
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean plus(Money money){
        if (currency.getCode() != money.getCurrency().getCode()){
            throw new RuntimeException("Different currencies cannot be added, currency: " + currency + ", plus currency: " + money.getCurrency());
        }

        amount += money.getAmount();

        return Boolean.TRUE;
    }

    public Boolean minus(Money money){
        if (currency.getCode() != money.getCurrency().getCode()){
            throw new RuntimeException("Different currencies cannot be subtracted, currency: " + currency + ", minus currency: " + money.getCurrency());
        }

        amount -= money.getAmount();

        return Boolean.TRUE;
    }
}
