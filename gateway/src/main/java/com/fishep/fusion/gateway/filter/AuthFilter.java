package com.fishep.fusion.gateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
public class AuthFilter implements GlobalFilter {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

//    @Value("${auth.guest.routes}")
//    private String[] guestRoutes;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("AuthFilter filter request");

        ServerHttpRequest request = exchange.getRequest();
        String uri = request.getPath().value();
        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

//        boolean match = guestRoutes.stream().anyMatch(routeRegex -> uri.matches(routeRegex));
//        if (match){
//            if (token != null) {
//                throw new RuntimeException("token is exist, please exit!");
//            }
//            return chain.filter(exchange);
//        }

//        if (token == null) {
//            throw new RuntimeException("token is not exist");
//        }
//
//        String[] split = token.split("\\s+");
//        String type = split[0];
//        String jws = split[1];
//
//        SecretKey sKey = Keys.hmacShaKeyFor(jwtSecretKey.getBytes());
//        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(sKey).build().parseClaimsJws(jws);
//
//        //OK, we can trust this JWT
//        JwsHeader header = claimsJws.getHeader();
//        Claims body = claimsJws.getBody();
//        String subject = body.getSubject();
//        Date expiration = body.getExpiration();
//        Long uid = body.get("uid", Long.class);
//        String signature = claimsJws.getSignature();

        return chain.filter(exchange);
    }
}
