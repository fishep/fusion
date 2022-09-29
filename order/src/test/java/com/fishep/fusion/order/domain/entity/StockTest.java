package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Quantity;
import com.fishep.fusion.common.type.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    void newStock() {

        Stock stock = new Stock(new ProductId(), new Quantity(Unit.PIECES, 100));

        assertNotNull(stock.getId().getValue());
        assertEquals(100, stock.getCount().getValue());

        Boolean flag = stock.deduct(new Quantity(Unit.PIECES, 2));
        assertTrue(flag);
        assertEquals(98, stock.getCount().getValue());
    }
}