package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.order.common.type.ProductId;
import com.fishep.fusion.order.common.type.StockId;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class Stock {

    private StockId id;

    private ProductId productId;

    private Integer count;

    private Instant createdAt;

    private Instant updatedAt;

    public Stock(ProductId productId, Integer count) {
        this.id = new StockId();
        this.productId = productId;
        this.count = count;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Stock(StockId id, ProductId productId, Integer count) {
        this.id = id;
        this.productId = productId;
        this.count = count;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public StockId getId() {
        return id;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Integer getCount() {
        return count;
    }

    public Boolean deduct(Integer num) {
        if (num > count) {
            throw new RuntimeException("stock is not enough, count: " + count + ", need: " + num);
        }

        count -= num;

        return Boolean.TRUE;
    }
}
