package com.fishep.fusion.order.interfaces.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CreateOrderRequest {

    @Data
    public static class Product {
        public Long id;
        public String unit;
        public Integer count;
    }

    @NotNull
    public Long accountId;

    @NotNull
    public String currency;

    @NotNull
    public List<CreateOrderRequest.Product> products;

}
