package com.fishep.fusion.order.infra.mapper;

import com.fishep.fusion.order.infra.model.OrderProductDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface OrderProductMapper {

    @Insert("insert into `order_products` (`id`, `order_id`, `currency`, `product_id`, `product_count`, `product_price`, `product_amount`, `created_at`, `updated_at`)" +
            "VALUES(#{op.id}, #{op.orderId}, #{op.currency}, #{op.productId}, #{op.productCount}, #{op.productPrice}, #{op.productAmount}, #{op.createdAt}, #{op.updatedAt})")
    Boolean insert(@Param("op") OrderProductDO op);

}
