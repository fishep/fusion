package com.fishep.fusion.user.infra.mapper;

import com.fishep.fusion.user.infra.model.AccountDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AccountMapper {

    @Select("select `id`, `number`, `user_id` AS userId, `name`, `currency`, `amount`, `quota`, `created_at` AS createdAt, `updated_at` AS updatedAt from `accounts` where id = #{id}")
    AccountDO select(@Param("id") Long id);

}
