package com.fishep.fusion.user.interfaces.receiver;

import com.fishep.fusion.user.interfaces.request.OrderCreatedMessage;
import org.springframework.messaging.Message;

public interface OrderMessageReceiver {

    void recv(Message<String> message);
//    void recv(Message<OrderCreatedMessage> message);

}
