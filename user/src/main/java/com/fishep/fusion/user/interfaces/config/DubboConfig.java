package com.fishep.fusion.user.interfaces.config;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@DubboComponentScan({"com.fishep.fusion.user.interfaces.rpc"})
public class DubboConfig {
}
