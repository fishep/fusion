package com.fishep.fusion.order.infra.producer.impl;

import com.fishep.fusion.order.domain.message.OrderCreated;
import com.fishep.fusion.order.domain.producer.OrderMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(Source.class)
public class OrderMessageProducerImpl implements OrderMessageProducer {

    @Autowired
    private MessageChannel output;

    @Override
    public Boolean send(OrderCreated orderCreated) {

        boolean flag = output.send(MessageBuilder.withPayload(orderCreated).build());
        if (!flag){
            throw new RuntimeException("OrderCreated message send fail, " + orderCreated);
        }

        log.info("OrderMessageProducerImpl send message: " + orderCreated);

        return flag;
    }
}
