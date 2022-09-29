package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Quantity;
import com.fishep.fusion.common.type.Unit;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.entity.Stock;
import com.fishep.fusion.order.domain.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class StockRepositoryImplTest {

    @Autowired
    StockRepository stockRepository;

    @Test
    void find() {

        List<OrderProduct> orderProducts = new ArrayList<>();
        orderProducts.add(new OrderProduct(new ProductId(1570262577389624911L), new Quantity(Unit.PCS, 1), new Money("CNY", 100)));
        orderProducts.add(new OrderProduct(new ProductId(1570262577389624922L), new Quantity(Unit.PCS, 2), new Money("CNY", 200)));

        List<Stock> stocks = stockRepository.find(orderProducts);

        assertNotNull(stocks);
        assertEquals(2, stocks.size());
    }

    @Test
    void save() {
        List<Stock> stocks = new ArrayList<>();
        Stock stock1 = new Stock(new ProductId(1570262577389624911L), new Quantity(Unit.PCS, 10));
        Stock stock2 = new Stock(new ProductId(1570262577389624922L), new Quantity(Unit.PCS, 20));
        stocks.add(stock1);
        stocks.add(stock2);

        Boolean ret = stockRepository.save(stocks);

        assertTrue(ret);
    }
}