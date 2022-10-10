package com.fishep.fusion.order.application.service;

import com.fishep.fusion.order.application.cqe.PlaceOrderCommand;
import com.fishep.fusion.order.application.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ShopServiceIntegrationTest {

    @Autowired
    ShopService shopService;

    @Test
    void placeOrderTest() {

        List<PlaceOrderCommand.Product> ps = new ArrayList<>();
        PlaceOrderCommand.Product p1 = new PlaceOrderCommand.Product(1570262577389624911L, "PCS", 1);
        PlaceOrderCommand.Product p2 = new PlaceOrderCommand.Product(1570262577389624922L, "PCS", 2);
        ps.add(p1);
        ps.add(p2);
        PlaceOrderCommand placeOrderCommand = new PlaceOrderCommand(1572870916451594444L, "CNY", ps);

        OrderDTO orderDTO = shopService.placeOrder(placeOrderCommand);

        assertNotNull(orderDTO);
        assertEquals(5, orderDTO.getAmount().getValue());
//        assertEquals(95, account.getAmount().getValue());
//        assertEquals(9, stock1.getCount().getValue());
//        assertEquals(18, stock2.getCount().getValue());
    }
}