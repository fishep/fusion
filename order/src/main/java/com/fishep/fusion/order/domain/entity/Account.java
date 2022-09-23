package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Money;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class Account {

    private AccountId id;

    private Money amount;

    private Instant createdAt;

    private Instant updatedAt;

    public Account(Money amount) {
        this.id = new AccountId();
        this.amount = amount;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public AccountId getId() {
        return id;
    }

    public Money getAmount() {
        return amount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Boolean deduct(Money money) {
        amount.minus(money);

        return Boolean.TRUE;
    }
}
