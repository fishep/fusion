package com.fishep.fusion.common.type;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeRate {

    private Currency source;

    private Currency target;

    private BigDecimal rate;

    public ExchangeRate(Currency source, Currency target, BigDecimal rate) {
        this.source = source;
        this.target = target;
        this.rate = rate;
    }

    public Currency getSource() {
        return source;
    }

    public Currency getTarget() {
        return target;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public Money exchange(Money source) {
        if (!this.source.getCode().equals(source.getCurrency().getCode())) {
            throw new RuntimeException("Inconsistent exchange rate and currency, Money Currency: " + source.getCurrency() + ", Exchange Currency " + this.source);
        }

        BigDecimal amount = BigDecimal.valueOf(source.getAmount());

        BigDecimal exchange = amount.multiply(rate);

        Integer targetAmount = exchange.setScale(0, RoundingMode.DOWN).intValue();

        return new Money(target, targetAmount);
    }

}
