package com.fishep.fusion.product.domain.entity;

import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Unit;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class Product {

    private ProductId id;

    private String name;

    private Money price;

    private Unit unit;

    private Instant createdAt;

    private Instant updatedAt;

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public Unit getUnit() {
        return unit;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
