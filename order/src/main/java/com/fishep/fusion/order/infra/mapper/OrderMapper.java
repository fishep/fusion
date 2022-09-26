package com.fishep.fusion.order.infra.mapper;

import com.fishep.fusion.order.infra.model.OrderDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    @Insert("insert into `orders` (id, `account_id`, `number`, `currency`, `amount`, `created_at`, `updated_at`) VALUES (#{o.id}, #{o.accountId}, #{o.number}, #{o.currency}, #{o.amount}, #{o.createdAt}, #{o.updatedAt})")
    Boolean insert(@Param("o") OrderDO o);

}
