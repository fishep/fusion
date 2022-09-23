package com.fishep.fusion.common.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void test() {
        Quantity onePCS = new Quantity(Quantity.Unit.PIECES, 1);
        Quantity twoPCS = new Quantity(Quantity.Unit.PIECES, 2);

        Quantity threePCS = onePCS.plus(twoPCS);

        assertEquals(3, threePCS.getValue());

        Quantity oneMeter = new Quantity(Quantity.Unit.METER, 1);

        assertThrows(Exception.class, ()->{
            oneMeter.plus(threePCS);
        });
    }
}