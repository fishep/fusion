package com.fishep.fusion.user.domain.service;

import com.fishep.fusion.common.type.Email;
import com.fishep.fusion.common.type.UserId;
import com.fishep.fusion.common.type.UserName;
import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.extend.HashService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    HashService hashService;

    private static User user;
    private static String password;

    @BeforeAll
    private static void init()
    {
        user = new User();
        password = "hello world";
    }

    @Test
    @Order(1)
    void register() {
        user.setId(new UserId());
        user.setName(new UserName("testname"));
        user.setEmail(new Email("testname@email.com"));
        user.setPasswordHash(hashService.hash(password));
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());

        Boolean register = userService.register(user);

        assertTrue(register);
    }

    @Test
    @Order(2)
    void authentication() {
        Boolean authentication = userService.authentication(user, password, hashService);

        assertTrue(authentication);
    }
}