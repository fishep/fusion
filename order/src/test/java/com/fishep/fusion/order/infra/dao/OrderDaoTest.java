package com.fishep.fusion.order.infra.dao;

import com.fishep.fusion.order.infra.model.OrderDO;
import com.fishep.fusion.order.infra.model.OrderProductDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    void insert() {
        OrderDO order = new OrderDO(1570262577389629333L, 1570262577389629555L, "OR20220926000001", "CNY", 5, 1663214749L, 1663214749L);

        OrderProductDO product1 = new OrderProductDO(1570262577389629777L, 1570262577389629333L, "CNY", 1570262577389629001L, 1, 1, 1, 1663214749L, 1663214749L);
        OrderProductDO product2 = new OrderProductDO(1570262577389629778L, 1570262577389629333L, "CNY", 1570262577389629002L, 2, 2, 4, 1663214749L, 1663214749L);

        List<OrderProductDO> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        Boolean ret = orderDao.insert(order, products);

        assertTrue(ret);
    }
}