package com.fishep.fusion.order.infra.producer.impl;

import com.fishep.fusion.order.domain.message.OrderCreated;
import com.fishep.fusion.order.domain.producer.OrderMessageProducer;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageProducerImpl implements OrderMessageProducer {

    @Override
    public void send(OrderCreated orderCreated) {

    }
}
