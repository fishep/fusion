package com.fishep.fusion.order.application.cqe;

import com.fishep.fusion.common.type.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
public class PlaceOrderCommand {

    @Data
    @AllArgsConstructor
    public static class Product {
        public ProductId id;
        public Quantity quantity;

        public Product(Long id, String unit, Integer count) {
            this.id = new ProductId(id);
            this.quantity = new Quantity(unit, count);
        }
    }

    public PlaceOrderCommand(Long accountId, String currency, List<Product> products) {
        this.accountId = new AccountId(accountId);
        this.currency = new Currency(currency);
        this.products = products;
    }

    @NotNull
    public AccountId accountId;

    @NotNull
    public Currency currency;

    @NotNull
    public List<Product> products;

}
