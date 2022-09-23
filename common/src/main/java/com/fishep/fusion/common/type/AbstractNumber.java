package com.fishep.fusion.common.type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
abstract public class AbstractNumber {

    protected String value;

    public AbstractNumber() {
        this("XXXXXX");
    }
}
