package com.fishep.fusion.user.domain.producer;

import com.fishep.fusion.user.domain.message.RegisterSuccess;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserMessageProducerTest {

    @Autowired
    UserMessageProducer producer;

    @Test
    @Order(1)
    void send() {
        RegisterSuccess message = new RegisterSuccess();
        producer.send(message);

        assertTrue(Boolean.TRUE);
    }

}