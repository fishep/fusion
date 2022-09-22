package com.fishep.fusion.order.application.cqe;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class PlaceOrderCommand {

    @Data
    public class Product {
        public Long productId;
        public Integer productCount;
    }

    @NotNull
    public Long accountId;

    @NotNull
    public String currency;

    @NotNull
    public List<Product> products;

}
