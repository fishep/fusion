package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.order.common.type.OrderId;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private OrderId id;

    private Account account;

    private String number;

    private Money amount;

    private List<Product> products;

    private Instant createdAt;

    private Instant updatedAt;

    public Order(String number, Currency currency, Account account) {
        this.id = new OrderId();
        this.account = account;
        this.number = number;
        this.products = new ArrayList<>();
        this.amount = new Money(currency, 0);
    }

    public Order(String number, Currency currency, Account account, List<Product> products) {
        this.id = new OrderId();
        this.account = account;
        this.number = number;
        this.products = products;
        this.amount = new Money(currency, 0);

        this.calculateTotal();
    }

    public OrderId getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getNumber() {
        return number;
    }

    public Money getAmount() {
        return amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Money calculateTotal() {
        amount.setAmount(0);

        for (Product p : products) {
            amount.plus(p.totalPrice());
        }

        return amount;
    }

    public Boolean addProduct(Product product) {
        products.add(product);

        this.calculateTotal();

        return Boolean.TRUE;
    }
}
