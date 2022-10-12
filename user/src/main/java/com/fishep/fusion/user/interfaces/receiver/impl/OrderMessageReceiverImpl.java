package com.fishep.fusion.user.interfaces.receiver.impl;

import com.fishep.fusion.user.interfaces.receiver.OrderMessageReceiver;
import com.fishep.fusion.user.interfaces.request.OrderCreatedMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(Sink.class)
public class OrderMessageReceiverImpl implements OrderMessageReceiver {

    @Override
    @StreamListener(Sink.INPUT)
    public void recv(Message<OrderCreatedMessage> message) {
        log.info("OrderMessageReceiverImpl, recv message: " + message.getPayload());

        OrderCreatedMessage orderCreatedMessage = message.getPayload();

        log.info("account id : " + orderCreatedMessage.getAccountId().getValue());
        log.info("order number : " + orderCreatedMessage.getOrderNumber().getValue());
    }
}
