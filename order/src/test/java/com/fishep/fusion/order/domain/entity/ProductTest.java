package com.fishep.fusion.order.domain.entity;

import com.fishep.fusion.common.type.Lang;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.common.type.ProductName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void newProduct() {

        Product product1 = new Product(new ProductName("光模块", Lang.zh_CN), new Money("CNY", 10000));
        Product product2 = new Product(new ProductName("SFP", Lang.en_US), new Money("USD", 1426));

        assertNotNull(product1);
        assertNotNull(product2);

    }
}