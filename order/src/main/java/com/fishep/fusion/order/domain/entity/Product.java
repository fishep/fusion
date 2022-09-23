package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.ProductName;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class Product {

    private ProductId id;

    private ProductName name;

    private Money price;

    private Instant createdAt;

    private Instant updatedAt;

    public Product(ProductName name, Money price) {
        this.id = new ProductId();
        this.name = name;
        this.price = price;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public ProductId getId() {
        return id;
    }

    public ProductName getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
