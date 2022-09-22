package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.order.common.type.ProductId;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class Product {

    private ProductId id;

    private Integer count;

    private Money price;

    private Instant createdAt;

    private Instant updatedAt;

    public Product(Integer count, Money price) {
        this.id = new ProductId();
        this.count = count;
        this.price = price;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Product(ProductId id, Integer count, Money price) {
        this.id = id;
        this.count = count;
        this.price = price;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public ProductId getId() {
        return id;
    }

    public Integer getCount() {
        return count;
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

    public void setCount(Integer count) {
        this.count = count;
    }

    public Money totalPrice(){
        return new Money(price.getCurrency(), price.getAmount() * count);
    }

}
