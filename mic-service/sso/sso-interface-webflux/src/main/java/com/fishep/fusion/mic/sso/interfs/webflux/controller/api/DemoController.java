package com.fishep.fusion.mic.sso.interfs.webflux.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;

/**
 * @Author fly.fei
 * @Date 2025/3/29 11:50
 * @Desc
 **/
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        log.info("hello");

        return Mono.just("hello !");
    }

    @GetMapping("/helloWorld")
    public Flux<String> helloWorld() {
        log.info("helloWorld");

        ArrayList<String> list = new ArrayList<>();
        list.add("hello ");
        list.add("world !");

        return Flux.fromIterable(list);
    }

    @GetMapping("/interval")
    public Flux<String> interval() {
        log.trace("before interval");

        Flux<String> flux = Flux.interval(Duration.ofSeconds(1)).map(input -> {
                if (input < 3) return "interval " + input + "\n";
                throw new RuntimeException("boom");
//                return "interval " + input + "\n";
            })
            .doOnSubscribe(t -> log.info("doOnSubscribe " + t.toString()))
            .onErrorReturn("boom ...");

        log.trace("end interval");

        return flux;
    }

}
