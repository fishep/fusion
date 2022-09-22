package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.order.common.type.ProductId;
import com.fishep.fusion.order.common.type.StockId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    void newStock() {
        Stock stock = new Stock(new StockId(), new ProductId(), 100);

        assertNotNull(stock.getId().getId());
        assertEquals(100, stock.getCount());

        Boolean flag = stock.deduct(2);
        assertTrue(flag);
        assertEquals(98, stock.getCount());
    }
}