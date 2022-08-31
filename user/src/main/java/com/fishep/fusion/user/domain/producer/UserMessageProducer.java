package com.fishep.fusion.user.domain.producer;

import com.fishep.fusion.user.domain.message.RegisterSuccess;

public interface UserMessageProducer {

    void send(RegisterSuccess message);

}
