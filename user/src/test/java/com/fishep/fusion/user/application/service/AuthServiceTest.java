package com.fishep.fusion.user.application.service;

import com.fishep.fusion.user.application.dto.UserDTO;
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
class AuthServiceTest {

    @Autowired
    AuthService authService;

    @Test
    @Order(1)
    void register() {
        String name = "name";
        String email = "name@email.com";
        String password = "secretpassword";

        UserDTO userDTO = authService.register(name, email, password);

        assertNotNull(userDTO);
        assertEquals(name, userDTO.getName());
        assertEquals(email, userDTO.getEmail());
    }
}