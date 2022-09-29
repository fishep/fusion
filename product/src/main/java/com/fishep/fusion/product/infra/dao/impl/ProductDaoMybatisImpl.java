package com.fishep.fusion.product.infra.dao.impl;

import com.fishep.fusion.product.infra.dao.ProductDao;
import com.fishep.fusion.product.infra.mapper.ProductMapper;
import com.fishep.fusion.product.infra.model.ProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoMybatisImpl implements ProductDao {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductDO> select(Long[] ids) {

        String join = this.join(ids);

        return this.select(join);
    }

    @Override
    public List<ProductDO> select(String ids) {
        List<ProductDO> productDOs = productMapper.select(ids);

        return productDOs;
    }

    private String join(Long[] ids) {

        String s = new String();
        for (int i = 0; i < ids.length; i++) {
            if (i == 0) {
                s += ids[i];
                continue;
            }

            s += ",";
            s += ids[i];
        }

        return s;
    }
}
