package com.fishep.fusion.product.application.service;

import com.fishep.fusion.product.application.cqe.ProductQuery;
import com.fishep.fusion.product.application.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void query() {
        Long[] ids = new Long[]{1570262577389624911L, 1570262577389624922L};

        ProductQuery query = new ProductQuery();
        query.setId(ids);

        List<ProductDTO> dtos = productService.query(query);

        assertNotNull(dtos);
        assertEquals(2, dtos.size());
    }
}