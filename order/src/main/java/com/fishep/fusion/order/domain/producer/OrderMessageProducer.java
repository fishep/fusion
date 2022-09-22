package com.fishep.fusion.order.domain.producer;

import com.fishep.fusion.order.domain.message.OrderCreated;

public interface OrderMessageProducer {

    void send(OrderCreated orderCreated);

}
