package com.fishep.fusion.user.infra.mapper;

import com.fishep.fusion.user.infra.model.UserDO;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    @Insert("insert into `users`(`id`, `name`, `email`, `password`, `created_at`, `updated_at`) VALUES (#{user.id}, #{user.name}, #{user.email}, #{user.password}, #{user.createdAt}, #{user.updatedAt})")
    Boolean insert(@Param("user") UserDO user);

    @Delete("delete from `users` where `id` = #{user.id}")
    Boolean delete(@Param("user") UserDO user);

    @Delete("delete from `users` where `id` = #{id}")
    Boolean deleteById(@Param("id") Long id);

    @Update("update `users` set `name`=#{user.name}, `email`=#{user.email}, `updated_at`=#{user.updatedAt} where `id` = #{user.id}")
    Boolean update(@Param("user") UserDO user);

    @Select("select `id`, `name`, `email`, `password`, `created_at` as createdAt, `updated_at` as updatedAt from `users` where `id` = #{id}")
    UserDO select(@Param("id") Long id);

    @Select("select `id`, `name`, `email`, `password`, `created_at` as createdAt, `updated_at` as updatedAt from `users` where `name` = #{name}")
    UserDO selectByName(@Param("name") String name);

    @Select("select `id`, `name`, `email`, `password`, `created_at` as createdAt, `updated_at` as updatedAt from `users` where `email` = #{email}")
    UserDO selectByEmail(@Param("email") String email);
}
