package com.fishep.fusion.user.application.service.impl;

import com.fishep.fusion.user.application.assembler.UserAssembler;
import com.fishep.fusion.user.application.cqe.UserEmailLoginCommand;
import com.fishep.fusion.user.application.cqe.UserNameLoginCommand;
import com.fishep.fusion.user.application.dto.TokenDTO;
import com.fishep.fusion.user.application.dto.UserDTO;
import com.fishep.fusion.user.application.dto.UserTokenDTO;
import com.fishep.fusion.user.application.service.AuthService;
import com.fishep.fusion.user.domain.entity.User;
import com.fishep.fusion.user.domain.extend.HashService;
import com.fishep.fusion.user.domain.message.RegisterSuccess;
import com.fishep.fusion.user.domain.producer.UserMessageProducer;
import com.fishep.fusion.user.domain.repository.UserRepository;
import com.fishep.fusion.user.domain.service.RegisterService;
import com.fishep.fusion.user.domain.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.crypto.SecretKey;
import javax.validation.Valid;
import java.time.Instant;
import java.util.Date;

@Service
@Validated
public class AuthServiceImpl implements AuthService {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    @Value("${jwt.expire}")
    private Integer jwtExpire;

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UserMessageProducer userMessageProducer;

    @Autowired
    private UserService userService;

    @Autowired
    private HashService hashService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO register(String name, String email, String password) {

        User user = userAssembler.toEntity(name, email, password);

        registerService.register(user);

        userMessageProducer.send(new RegisterSuccess());

        UserDTO userDTO = userAssembler.toDTO(user);

        return userDTO;
    }

    @Override
    public UserTokenDTO login(@Valid UserNameLoginCommand loginCommand) {
        User user = userRepository.find(loginCommand.getUserName());
        String password = loginCommand.getPassword();

        return this.login(user, password);
    }

    @Override
    public UserTokenDTO login(@Valid UserEmailLoginCommand loginCommand) {
        User user = userRepository.find(loginCommand.getUserEmail());
        String password = loginCommand.getPassword();

        return this.login(user, password);
    }

    private UserTokenDTO login(User user, String password) {
        Boolean flag = userService.authentication(user, password, hashService);
        if (!flag) {
            throw new RuntimeException("authentication fail, identify or password error");
        }

        JwtBuilder builder = Jwts.builder();
        builder.setSubject("auth");
        builder.setExpiration(Date.from(Instant.now().plusSeconds(jwtExpire)));
        builder.claim("uid", user.getId().getValue());
        builder.signWith(Keys.hmacShaKeyFor(jwtSecretKey.getBytes()));
        String jws = builder.compact();

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setAccessToken(jws);
        tokenDTO.setTokenType("Bearer");
        tokenDTO.setExpiresIn(jwtExpire);

        UserTokenDTO userTokenDTO = userAssembler.toUserTokenDTO(user, tokenDTO);

        return userTokenDTO;
    }
}
