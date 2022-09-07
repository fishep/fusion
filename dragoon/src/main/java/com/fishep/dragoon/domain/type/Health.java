package com.fishep.dragoon.domain.type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Health {

    public static final Integer ZERO = 0;

    private Integer blood = 0;

    public void increase(Integer blood)
    {
        this.blood += blood;
    }

    public void decrease(Integer blood)
    {
        this.blood -= blood;
    }
}
