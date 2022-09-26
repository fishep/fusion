package com.fishep.fusion.order.infra.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.fishep.fusion.order.infra.mapper")
public class MybatisConfig {
}
