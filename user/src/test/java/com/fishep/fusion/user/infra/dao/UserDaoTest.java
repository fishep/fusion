package com.fishep.fusion.user.infra.dao;

import cn.hutool.core.util.IdUtil;
import com.fishep.fusion.user.infra.model.UserDO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDaoTest {

    static private Long userId;
    static private UserDO userDO;

    @Autowired
    UserDao userDao;

    @BeforeAll
    static void init()
    {
        userId = IdUtil.getSnowflake().nextId();

        userDO = new UserDO();
        userDO.setId(userId);
        userDO.setName("name");
        userDO.setEmail("name@email.com");
        userDO.setPassword("***");
        userDO.setCreatedAt(Instant.now().getEpochSecond());
        userDO.setUpdatedAt(Instant.now().getEpochSecond());
    }

    @Test
    @Order(1)
    void insert() {
        Boolean flag = userDao.insert(userDO);

        assertTrue(flag);
    }

    @Test
    @Order(8)
    void delete() {
        Boolean flag = userDao.delete(userId);
        assertTrue(flag);
    }

    @Test
    @Order(9)
    void testDelete() {
        Boolean flag = userDao.delete(userDO);
        assertFalse(flag);
    }

    @Test
    @Order(2)
    void update() {
        userDO.setName("nameupdate");
        userDO.setEmail("nameupdate@email.com");
        userDO.setUpdatedAt(Instant.now().getEpochSecond());

        Boolean flag = userDao.update(userDO);

        assertTrue(flag);
    }

    @Test
    @Order(3)
    void select() {
        UserDO user = userDao.select(userId);
        assertNotNull(user);

        UserDO noUser = userDao.select(IdUtil.getSnowflake().nextId());
        assertNull(noUser);
    }

    @Test
    @Order(4)
    void testSelect() {
        UserDO u = new UserDO();
        u.setId(IdUtil.getSnowflake().nextId());
        u.setName("no");
        u.setEmail("no@email.com");
        u.setPassword("***");
        u.setCreatedAt(Instant.now().getEpochSecond());
        u.setUpdatedAt(Instant.now().getEpochSecond());

        UserDO noUser = userDao.select(u);
        assertNull(noUser);

        u.setId(userId);
        UserDO user = userDao.select(u);
        assertNotNull(user);
    }

    @Test
    @Order(5)
    void selectByName() {
        UserDO user = userDao.selectByName(userDO.getName());
        assertNotNull(user);
    }

    @Test
    @Order(6)
    void selectByEmail() {
        UserDO user = userDao.selectByEmail(userDO.getEmail());
        assertNotNull(user);
    }

    @Test
    @Order(7)
    void isExist() {
        Boolean flag = userDao.isExist(userDO);
        assertTrue(flag);
    }
}