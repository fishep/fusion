package com.fishep.fusion.product.infra.repository.impl;

import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.product.domain.entity.Product;
import com.fishep.fusion.product.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProductRepositoryImplTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void find() {
        ProductId pid1 = new ProductId(1570262577389624911L);
        ProductId pid2 = new ProductId(1570262577389624922L);
        List<ProductId> pids = new ArrayList<>();
        pids.add(pid1);
        pids.add(pid2);

        List<Product> products = productRepository.find(pids);

        assertNotNull(products);
        assertEquals(2, products.size());
    }
}