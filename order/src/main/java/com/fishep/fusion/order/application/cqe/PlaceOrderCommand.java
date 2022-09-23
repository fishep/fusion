package com.fishep.fusion.order.application.cqe;

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
        public Long productId;
        public String productUnit;
        public Integer productCount;
    }

    @NotNull
    public Long accountId;

    @NotNull
    public String currency;

    @NotNull
    public List<Product> products;

}
