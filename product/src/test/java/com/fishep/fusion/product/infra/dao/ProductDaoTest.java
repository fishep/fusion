package com.fishep.fusion.product.infra.dao;

import com.fishep.fusion.product.infra.model.ProductDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    void select() {

        Long[] ids = new Long[]{1570262577389624911L, 1570262577389624922L};

        List<ProductDO> productDOs = productDao.select(ids);

        assertNotNull(productDOs);
        assertEquals(2, productDOs.size());

        System.out.println(productDOs);
    }


}