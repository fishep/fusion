package com.fishep.fusion.user.infra.mapper;

import com.fishep.fusion.user.infra.model.AccountDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {

    @Select("select `id`, `number`, `user_id` AS userId, `name`, `currency`, `amount`, `quota`, `created_at` AS createdAt, `updated_at` AS updatedAt from `accounts` where id = #{id}")
    AccountDO select(@Param("id") Long id);

    @Insert("insert into `accounts`(`id`, `number`, `user_id`, `name`, `currency`, `amount`, `quota`, `created_at`, `updated_at`) " +
            "VALUES (#{a.id}, #{a.number},#{a.userId}, #{a.name}, #{a.currency}, #{a.amount}, #{a.quota}, #{a.createdAt}, #{a.updatedAt})")
    Boolean insert(@Param("a") AccountDO accountDO);

    @Update("update `accounts` set `amount` = #{a.amount}, `quota` = #{a.quota}, `updated_at` = #{a.updatedAt} where `id` = #{a.id}")
    Boolean update(@Param("a") AccountDO accountDO);

}
