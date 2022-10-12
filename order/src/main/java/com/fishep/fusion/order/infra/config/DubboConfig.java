package com.fishep.fusion.order.infra.config;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@DubboComponentScan({"com.fishep.fusion.order.infra.producer.impl"})
public class DubboConfig {
}
