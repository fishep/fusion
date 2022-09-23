package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private OrderId id;

    private AccountId accountId;

    private OrderNumber number;

    private Money amount;

    private List<OrderProduct> orderProducts;

    private Instant createdAt;

    private Instant updatedAt;

    public Order(OrderNumber number, Currency currency, AccountId accountId) {
        this.id = new OrderId();
        this.accountId = accountId;
        this.number = number;
        this.orderProducts = new ArrayList<>();
        this.amount = new Money(currency, 0);
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Order(OrderNumber number, Currency currency, AccountId accountId, List<OrderProduct> orderProducts) {
        this.id = new OrderId();
        this.accountId = accountId;
        this.number = number;
        this.orderProducts = orderProducts;
        this.amount = new Money(currency, 0);
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();

        this.calculateTotal();
    }

    public Order(Currency currency, AccountId accountId) {
        this.id = new OrderId();
        this.accountId = accountId;
        this.number = new OrderNumber();
        this.orderProducts = new ArrayList<>();
        this.amount = new Money(currency, 0);
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Order(Currency currency, AccountId accountId, List<OrderProduct> orderProducts) {
        this.id = new OrderId();
        this.accountId = accountId;
        this.number = new OrderNumber();
        this.orderProducts = orderProducts;
        this.amount = new Money(currency, 0);
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();

        this.calculateTotal();
    }

    public OrderId getId() {
        return id;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public OrderNumber getNumber() {
        return number;
    }

    public Money getAmount() {
        return amount;
    }

    public List<OrderProduct> getProducts() {
        return orderProducts;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Money calculateTotal() {
        amount.setValue(0);

        for (OrderProduct p : orderProducts) {
            amount.plus(p.totalPrice());
        }

        return amount;
    }

    public Boolean addProduct(OrderProduct orderProduct) {
        orderProducts.add(orderProduct);

        this.calculateTotal();

        return Boolean.TRUE;
    }
}
