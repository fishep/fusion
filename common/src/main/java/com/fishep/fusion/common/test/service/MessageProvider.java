package com.fishep.fusion.common.test.service;

import com.fishep.fusion.common.test.message.TestMessage;

public interface MessageProvider {

    boolean send(String message);

    boolean send(TestMessage message);

}
