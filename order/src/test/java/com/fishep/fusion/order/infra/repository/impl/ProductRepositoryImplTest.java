package com.fishep.fusion.order.infra.repository.impl;

import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Quantity;
import com.fishep.fusion.common.type.Unit;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class ProductRepositoryImplTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void flush() {

        List<OrderProduct> orderProducts = new ArrayList<>();
        orderProducts.add(new OrderProduct(new ProductId(1570262577389624911L), new Quantity(Unit.PCS, 1)));
        orderProducts.add(new OrderProduct(new ProductId(1570262577389624922L), new Quantity(Unit.PCS, 2)));

        productRepository.flush(orderProducts);

        assertNotNull(orderProducts.get(0).getPrice());
        assertNotNull(orderProducts.get(1).getPrice());
    }
}