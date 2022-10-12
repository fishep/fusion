package com.fishep.fusion.common.test.service;

import com.fishep.fusion.common.test.message.TestMessage;
import org.springframework.messaging.Message;

public interface MessageReceiver {

    void recv(Message<String> message);

    void recvMessage(Message<TestMessage> message);

}
