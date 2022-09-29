package com.fishep.fusion.product.infra.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.fishep.fusion.product.infra.mapper")
public class MybatisConfig {
}
