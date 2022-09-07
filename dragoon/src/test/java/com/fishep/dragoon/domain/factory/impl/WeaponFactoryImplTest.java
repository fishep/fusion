package com.fishep.dragoon.domain.factory.impl;

import com.fishep.dragoon.domain.entity.Staff;
import com.fishep.dragoon.domain.entity.Sword;
import com.fishep.dragoon.domain.factory.WeaponFactory;
import com.fishep.dragoon.domain.type.DamageType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *     剑（Sword）   物理攻击
 *     法杖（Staff） 火，冰
 */

@SpringBootTest
class WeaponFactoryImplTest {

    @Autowired
    WeaponFactory weaponFactory;

    @Test
    void swordFeature() {
        Sword sword = weaponFactory.createSword("Sword001", 10, DamageType.PHYSICS);
        assertNotNull(sword);

        assertThrows(RuntimeException.class, ()->{
            weaponFactory.createSword("Sword001", 10, DamageType.ICE);
        });

        assertThrows(RuntimeException.class, ()->{
            weaponFactory.createSword("Sword001", 10, DamageType.FIRE);
        });
    }

    @Test
    void staffFeature() {
        Staff staff001 = weaponFactory.createStaff("Staff001", 0, DamageType.ICE);
        assertNotNull(staff001);
        assertEquals(DamageType.ICE, staff001.getDamageType());

        Staff staff002 = weaponFactory.createStaff("Staff002", 0, DamageType.FIRE);
        assertNotNull(staff002);
        assertEquals(DamageType.FIRE, staff002.getDamageType());

        assertThrows(RuntimeException.class, ()->{
            weaponFactory.createStaff("Staff003", 0, DamageType.PHYSICS);
        });
    }
}