package com.fishep.fusion.common.type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Quantity {

    public enum Unit {
        PCS, PIECES, BOX, METER, CENTIMETER
    }

    private Unit unit;

    private Integer value;

    public Quantity(String unit, Integer value) {
        this.unit = Unit.valueOf(unit);
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public Integer getValue() {
        return value;
    }

    public Quantity plus(Quantity quantity) {
        if (this.unit != quantity.getUnit()) {
            throw new RuntimeException("The unit of quantity is inconsistent , One is " + unit + ", The other is " + quantity.getUnit());
        }

        value += quantity.getValue();

        return this;
    }

    public Quantity minus(Quantity quantity) {
        if (this.unit != quantity.getUnit()) {
            throw new RuntimeException("The unit of quantity is inconsistent , One is " + unit + ", The other is " + quantity.getUnit());
        }

        value -= quantity.getValue();

        return this;
    }

    public Boolean gt(Quantity quantity) {
        if (this.unit != quantity.getUnit()) {
            throw new RuntimeException("The unit of quantity is inconsistent , One is " + unit + ", The other is " + quantity.getUnit());
        }

        return value > quantity.getValue();
    }

    public Boolean ge(Quantity quantity) {
        if (this.unit != quantity.getUnit()) {
            throw new RuntimeException("The unit of quantity is inconsistent , One is " + unit + ", The other is " + quantity.getUnit());
        }

        return value >= quantity.getValue();
    }

    public Boolean lt(Quantity quantity) {
        if (this.unit != quantity.getUnit()) {
            throw new RuntimeException("The unit of quantity is inconsistent , One is " + unit + ", The other is " + quantity.getUnit());
        }

        return value < quantity.getValue();
    }

    public Boolean le(Quantity quantity) {
        if (this.unit != quantity.getUnit()) {
            throw new RuntimeException("The unit of quantity is inconsistent , One is " + unit + ", The other is " + quantity.getUnit());
        }

        return value <= quantity.getValue();
    }

}
