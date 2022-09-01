package com.fishep.fusion.user.domain.extend;

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
class HashServiceTest {

    @Autowired
    HashService hashService;

    @Test
    @Order(1)
    void hash() {

        String data = "this is plaintext";
        String hash = hashService.hash(data);

        System.out.println(hash);

        assertNotNull(hash);
        assertNotEquals(0, hash.length());
    }
}