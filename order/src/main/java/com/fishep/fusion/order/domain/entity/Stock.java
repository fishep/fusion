package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Quantity;
import com.fishep.fusion.common.type.StockId;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class Stock {

    private StockId id;

    private ProductId productId;

    private Quantity count;

    private Instant createdAt;

    private Instant updatedAt;

    public Stock(ProductId productId, Quantity count) {
        this.id = new StockId();
        this.productId = productId;
        this.count = count;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Stock(StockId id, ProductId productId, Quantity count) {
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

    public Quantity getCount() {
        return count;
    }

    public Boolean deduct(Quantity num) {
        if (count.lt(num)) {
            throw new RuntimeException("stock is not enough, count: " + count + ", need: " + num);
        }

        count.minus(num);

        return Boolean.TRUE;
    }
}
