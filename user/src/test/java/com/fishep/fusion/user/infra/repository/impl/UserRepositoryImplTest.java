package com.fishep.fusion.user.infra.repository.impl;

import com.fishep.fusion.common.type.Email;
import com.fishep.fusion.user.common.type.UserId;
import com.fishep.fusion.user.common.type.UserName;
import com.fishep.fusion.user.common.type.UserPassword;
import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    static private User user;

    @BeforeAll
    static void init() {
        user = new User();
        user.setId(UserId.generator());
        user.setName(new UserName("name"));
        user.setEmail(new Email("name@email.com"));
        user.setPasswordHash("********");
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
    }

    @Test
    @Order(2)
    void find() {
        User u = userRepository.find(user.getId());
        assertNotNull(u);
    }

    @Test
    @Order(3)
    void testFind() {
        User u = userRepository.find(user.getName());
        assertNotNull(u);
    }

    @Test
    @Order(4)
    void testFind1() {
        User u = userRepository.find(user.getEmail());
        assertNotNull(u);
    }

    @Test
    @Order(5)
    void findByAny() {
        User u = userRepository.findByAny(user.getName(), user.getEmail());
        assertNotNull(u);
    }

    @Test
    @Order(1)
    void save() {
        Boolean flag = userRepository.save(user);
        assertTrue(flag);

        user.setName(new UserName("name1"));
        user.setEmail(new Email("name1@email.com"));
        assertTrue(userRepository.save(user));
    }

    @Test
    @Order(6)
    void isExist() {
        Boolean flag = userRepository.isExist(user);
        assertTrue(flag);

        User u = new User();
        u.setId(UserId.generator());

        assertThrows(RuntimeException.class, () -> {
            userRepository.isExist(u);
        });
    }

    @Test
    @Order(7)
    void isNotExist() {
        User u = new User();
        u.setId(UserId.generator());
        u.setName(new UserName("testisnotexist"));
        u.setEmail(new Email("testisnotexist@email.com"));
        u.setPasswordHash("***********");
        u.setCreatedAt(Instant.now());
        u.setUpdatedAt(Instant.now());

        Boolean flag = userRepository.isNotExist(u);
        assertTrue(flag);

        assertThrows(RuntimeException.class, () -> {
            userRepository.isNotExist(user);
        });
    }

    @Test
    @Order(8)
    void remove() {
        Boolean flag = userRepository.remove(user);

        assertTrue(flag);
    }

}