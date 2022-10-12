package com.fishep.fusion.common.test.service.impl;

import com.fishep.fusion.common.test.message.TestMessage;
import com.fishep.fusion.common.test.service.MessageReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(Sink.class)
public class MessageReceiverImpl implements MessageReceiver {

    @Value("${server.port}")
    private String port;

    @Override
    @StreamListener(Sink.INPUT)
    public void recv(Message<String> message) {
        log.info("port: " + port + ", recv string: " + message.getPayload());
    }

    @Override
    @StreamListener(Sink.INPUT)
    public void recvMessage(Message<TestMessage> message) {
        log.info("port: " + port + ", recv message: " + message.getPayload());
    }
}
