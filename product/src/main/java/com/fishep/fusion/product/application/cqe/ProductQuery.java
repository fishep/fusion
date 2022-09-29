package com.fishep.fusion.product.application.cqe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuery {

    @NotNull
    public Long[] id;

}
