package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.OrderProductId;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Quantity;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class OrderProduct {

    private OrderProductId id;

    private ProductId productId;

    private Quantity count;

    private Money price;

    private Instant createdAt;

    private Instant updatedAt;

    public OrderProduct(ProductId productId, Quantity count, Money price) {
        this.id = new OrderProductId();
        this.productId = productId;
        this.count = count;
        this.price = price;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public OrderProduct(ProductId productId, Quantity count) {
        this.id = new OrderProductId();
        this.productId = productId;
        this.count = count;
//        this.price = price;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public OrderProductId getId() {
        return id;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Quantity getCount() {
        return count;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setCount(Quantity count) {
        this.count = count;
    }

    public Money totalPrice() {
        return new Money(price.getCurrency(), price.getValue() * count.getValue());
    }

    public Boolean changePrice(Money price) {
        if (this.price == null){
            this.setPrice(price);
            return Boolean.TRUE;
        }

        this.price.assign(price);

        return Boolean.TRUE;
    }
}
