show databases ;

drop database fusion_product;

create database fusion_product;

use fusion_product;

show tables;

drop table if exists products;
create table `products`
(
    `id` bigint not null comment 'id',
    `name` varchar(255) not null comment '默认产品名',
    `currency` char(3) not null comment '默认产品计价币种,例如：USD,CNY',
    `price` int unsigned not null comment '产品单价，单位：分',
    `unit` varchar(255) not null comment '计量单位，PCS, PIECES, BOX, METER, CENTIMETER',
    `created_at` bigint not null default 0 comment '创建时间',
    `updated_at` bigint not null default 0 comment '更新时间',
    primary key (`id`)
);

drop table if exists product_prices;
create table `product_prices`
(
    `id` bigint not null comment 'id',
    `product_id` bigint not null comment '产品id',
    `zone_id` bigint not null comment '地区id',
    `currency` char(3) not null comment '币种,例如：USD,CNY',
    `price` int unsigned not null comment '产品单价，单位：分',
    `unit` varchar(15) not null comment '计量单位，PCS, PIECES, BOX, METER, CENTIMETER',
    `created_at` bigint not null default 0 comment '创建时间',
    `updated_at` bigint not null default 0 comment '更新时间',
    primary key (`id`),
    unique key (`zone_id`, `product_id`),
    foreign key product_prices_product_id_foreign(`product_id`) REFERENCES products(`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

drop table if exists product_descriptions;
create table `product_descriptions`
(
    `id` bigint not null comment 'id',
    `product_id` bigint not null comment '产品id',
    `lang` varchar(15) not null comment '语种, zh_CN,en_US',
    `name` varchar(255) not null comment '产品名',
    `created_at` bigint not null default 0 comment '创建时间',
    `updated_at` bigint not null default 0 comment '更新时间',
    primary key (`id`),
    unique key (`lang`, `product_id`),
    foreign key product_descriptions_product_id_foreign(`product_id`) REFERENCES products(`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into products (id, name, currency, price, unit, created_at, updated_at) VALUES (1570262577389624911, "SFP", "CNY", 1, "PCS", 1663214749, 1663214749);
insert into products (id, name, currency, price, unit, created_at, updated_at) VALUES (1570262577389624922, "SFP+", "CNY", 2, "PCS", 1663214749, 1663214749);
update products set updated_at = 1663214777 where id = 1570262577389624922;
select * from products where id = 1570262577389624922;
delete from products where id = 1570262577389624922;

select * from products where id in (1570262577389624922, 1570262577389624911);

select id, name, currency, price, unit, created_at AS createdAt, updated_at AS updatedAt from products where id in("1570262577389624922", "1570262577389624911");
select id, name, currency, price, unit, created_at AS createdAt, updated_at AS updatedAt from products where id in(1570262577389624922, 1570262577389624911);
