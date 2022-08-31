package com.fishep.fusion.user.infra.producer.impl;

import com.fishep.fusion.user.domain.message.RegisterSuccess;
import com.fishep.fusion.user.domain.producer.UserMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserMessageProducerImpl implements UserMessageProducer {
    @Override
    public void send(RegisterSuccess message) {
        log.info("RegisterSuccess message send");
    }
}
