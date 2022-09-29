package com.fishep.fusion.product.infra.mapper;

import com.fishep.fusion.product.infra.model.ProductDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface ProductMapper {

//    @Select({"select id, name, currency, price, unit, created_at AS createdAt, updated_at AS updatedAt from products where id in(${ids})"})
//    List<ProductDO> select(@Param("ids") Long[] ids);

//    @Select("select id, name, currency, price, unit, created_at AS createdAt, updated_at AS updatedAt from products where id in(#{ids})")
    @Select("select id, name, currency, price, unit, created_at AS createdAt, updated_at AS updatedAt from products where id in(${ids})")
    List<ProductDO> select(@Param("ids") String ids);

//    @SelectProvider(type = ProductMapper.class, method = "selectForIn")
//    List<ProductDO> select(@Param("ids") Long[] ids);
//
//    default String selectForIn(@Param("ids") Long[] ids) {
//        String sql = new String();
//        for (int i = 0; i < ids.length; i++) {
//            if (i == 0) {
//                sql += ids[i];
//                continue;
//            }
//
//            sql += "," + ids[i];
//        }
//
//        sql = "select id, name, currency, price, unit, created_at AS createdAt, updated_at AS updatedAt from products where id in(" + sql + ")";
//
//        return sql;
//    }
}
