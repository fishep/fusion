package com.fishep.fusion.user.domain.repository;

import com.fishep.fusion.common.type.Email;
import com.fishep.fusion.common.type.UserId;
import com.fishep.fusion.common.type.UserName;
import com.fishep.fusion.user.domain.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest {

    static private User user;

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    static void init() {
        user = new User();
        user.setId(new UserId());
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
    @Order(6)
    void refresh() {
        User u = userRepository.refresh(user);

        assertEquals(u, user);
    }

    @Test
    @Order(1)
    void save() {
        Boolean flag = userRepository.save(user);
        assertTrue(flag);

        user.setName(new UserName("name1"));
        user.setEmail(new Email("name1@email.com"));
        user.setUpdatedAt(Instant.now());
        assertTrue(userRepository.save(user));
    }

    @Test
    @Order(7)
    void isExist() {
        Boolean flag = userRepository.isExist(user);
        assertTrue(flag);
    }

    @Test
    @Order(9)
    void isNotExist() {
        Boolean flag = userRepository.isNotExist(user);
        assertTrue(flag);
    }

    @Test
    @Order(8)
    void remove() {
        Boolean flag = userRepository.remove(user);
        assertTrue(flag);
    }
}