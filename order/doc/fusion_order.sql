show databases ;

drop database fusion_order;

create database fusion_order;

use fusion_order;

show tables;

drop table if exists orders;
create table `orders`
(
    `id` bigint not null comment 'id',
    `account_id` char(32) not null comment 'accounts.uuid',
    `number` char(16) not null comment '订单编号',
    `currency` char(3) not null comment '订单币种,例如：USD,CNY',
    `amount` int unsigned not null comment '订单金额，单位：分',
    `created_at` bigint not null default 0 comment '创建时间',
    `updated_at` bigint not null default 0 comment '更新时间',
    primary key (`id`),
    unique key (`number`),
    index (`account_id`)
);

drop table if exists order_products;
create table `order_products`
(
    `id` bigint not null comment 'id',
    `order_id` bigint not null comment 'orders.id',
    `currency` char(3) not null comment '币种,例如：USD,CNY',
    `product_id` char(32) not null comment '产品id',
    `product_count` int unsigned not null comment '产品总数',
    `product_price` int unsigned not null comment '产品单价，单位：分',
    `product_amount` int unsigned not null comment '产品总额，单位：分',
    `created_at` bigint not null default 0 comment '创建时间',
    `updated_at` bigint not null default 0 comment '更新时间',
    primary key (`id`),
    unique key (`order_id`, `product_id`),
    index (`product_id`),
    foreign key order_products_order_id_foreign(`order_id`) REFERENCES orders(`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into `orders` (id, `account_id`, `number`, `currency`, `amount`, `created_at`, `updated_at`) VALUES (1570262577389629444, 1570262577389629555, 'XXX', 'CNY', 10000, 1663214749, 0);
delete from `orders` where `id` = 1570262577389629444;
update `orders` set `updated_at` = 1663214799 where `id` = 1570262577389629444;
select * from `orders`;
select * from `orders` where `id` = 1570262577389629444;

insert into `order_products` (`id`, `order_id`, `currency`, `product_id`, `product_count`, `product_price`, `product_amount`, `created_at`, `updated_at`)
VALUES(1570262577389629888, 1570262577389629444, 'CNY', 1570262577389629001, 1, 2, 2, 1663214749, 0);
insert into `order_products` (`id`, `order_id`, `currency`, `product_id`, `product_count`, `product_price`, `product_amount`, `created_at`, `updated_at`)
VALUES(1570262577389629666, 1570262577389629444, 'CNY', 1570262577389629002, 2, 1, 2, 1663214749, 0);
delete from `order_products` where `id` = 1570262577389629888;
update `order_products` set `updated_at` = 1663214799 where `id` = 1570262577389629888;
select * from `order_products`;
select * from `order_products` where `id` = 1570262577389629888;