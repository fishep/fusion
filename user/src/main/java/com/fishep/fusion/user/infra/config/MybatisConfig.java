package com.fishep.fusion.user.infra.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.fishep.fusion.user.infra.mapper")
public class MybatisConfig {
}
