package com.fishep.fusion.common.test.service.impl;

import com.fishep.fusion.common.test.message.TestMessage;
import com.fishep.fusion.common.test.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@EnableBinding(Source.class)
public class MessageProviderImpl implements MessageProvider {

    @Value("${server.port}")
    private String port;

    @Autowired
    private MessageChannel output;

    @Override
    public boolean send(String message) {
        String serial = UUID.randomUUID().toString();

        message = serial + " | " + message;

        boolean flag = output.send(MessageBuilder.withPayload(message).build());

        log.info("port: " + port + ", send message: " + message);

        return flag;
    }

    @Override
    public boolean send(TestMessage message) {
        boolean flag = output.send(MessageBuilder.withPayload(message).build());

        log.info("port: " + port + ", send message: " + message);

        return flag;
    }
}
