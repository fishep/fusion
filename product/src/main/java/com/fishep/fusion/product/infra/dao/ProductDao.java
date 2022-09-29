package com.fishep.fusion.product.infra.dao;

import com.fishep.fusion.product.infra.model.ProductDO;

import java.util.List;

public interface ProductDao {

    List<ProductDO> select(Long[] ids);

    List<ProductDO> select(String ids);

}
