show databases ;

create database fusion_user;

use fusion_user;

show tables ;

drop table if exists `users`;
create table `users`
(
    `id` bigint not null comment 'id',
    `name` varchar(255) not null comment '用户名',
    `email` varchar(255) not null comment '邮箱',
    `password` varchar(255) not null comment '密码',
    `created_at` bigint not null default 0 comment '创建时间',
    `updated_at` bigint not null default 0 comment '更新时间',
    primary key (`id`),
    unique key (`name`),
    unique key (`email`)
);

insert into `users`(`id`, `name`, `email`, `password`, `created_at`) VALUES (1, "username", "user@email.com", "***", 1661832437460);

delete from `users` where `id` = 1;

update `users` set `name`="usernameupdated", `email`="userupdated@email.com", `updated_at`=1661832437466 where `id` = 1;

select * from `users`;

select * from `users` where `id` = 1;