package com.fishep.fusion.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomGlobalFilter  implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

//        String value = exchange.getRequest().getQueryParams().getFirst("key");
//        if (value != null && value.equals("val"))
//        {
//            log.info("CustomGlobalFilter key = val");
//        }

        log.info("CustomGlobalFilter filter request");

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
