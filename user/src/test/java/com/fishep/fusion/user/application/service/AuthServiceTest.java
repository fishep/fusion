package com.fishep.fusion.user.application.service;

import com.fishep.fusion.user.application.cqe.UserNameLoginCommand;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.dto.UserTokenDTO;
import com.fishep.fusion.user.common.type.UserName;
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
        String name = "hello";
        String email = "hello@email.com";
        String password = "helloworld";

        UserDTO userDTO = authService.register(name, email, password);

        assertNotNull(userDTO);
        assertEquals(name, userDTO.getName());
        assertEquals(email, userDTO.getEmail());
    }

    @Test
    @Order(2)
    void login() {
        UserNameLoginCommand loginCommand = new UserNameLoginCommand(new UserName("hello"), "helloworld");

        UserTokenDTO userTokenDTO = authService.login(loginCommand);

        assertNotNull(userTokenDTO);

        loginCommand.setPassword("hhhhhhhh");

        assertThrows(RuntimeException.class, ()->{
            authService.login(loginCommand);
        });
    }
}