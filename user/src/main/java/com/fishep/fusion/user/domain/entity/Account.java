package com.fishep.fusion.user.domain.entity;

import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.AccountNumber;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.UserId;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class Account {

    private AccountId id;

    private AccountNumber number;

    private UserId userId;

    private String name;

    private Money amount;

    private Money quota;

    private Instant createdAt;

    private Instant updatedAt;

    public Account(UserId userId, Money amount) {
        this.id = new AccountId();
        this.number = new AccountNumber();
        this.userId = userId;
        this.name = "";
        this.amount = amount;
        this.quota = new Money(amount.getCurrency(), 0);
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public AccountId getId() {
        return id;
    }

    public AccountNumber getNumber() {
        return number;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Money getAmount() {
        return amount;
    }

    public Money getQuota() {
        return quota;
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
