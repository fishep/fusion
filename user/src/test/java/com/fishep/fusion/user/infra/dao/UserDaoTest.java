package com.fishep.fusion.user.infra.dao;

import cn.hutool.core.util.IdUtil;
import com.fishep.fusion.user.infra.model.UserDO;
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
class UserDaoTest {

    static private Long userId = IdUtil.getSnowflake().nextId();

    @Autowired
    UserDao userDao;

    @Test
    @Order(1)
    void insert() {
        UserDO userDO = new UserDO();
        userDO.setId(userId);
        userDO.setName("name");
        userDO.setEmail("name@email.com");
        userDO.setPassword("***");
        userDO.setCreatedAt(System.currentTimeMillis());

        Boolean flag = userDao.insert(userDO);

        assertTrue(flag);
    }

    @Test
    @Order(2)
    void update() {
        UserDO userDO = new UserDO();
        userDO.setId(userId);
        userDO.setName("nameupdate");
        userDO.setEmail("nameupdate@email.com");
        userDO.setUpdatedAt(System.currentTimeMillis());

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
    void delete() {
        Boolean flag = userDao.delete(userId);

        assertTrue(flag);
    }
}