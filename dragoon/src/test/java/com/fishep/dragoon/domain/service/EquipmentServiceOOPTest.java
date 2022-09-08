package com.fishep.dragoon.domain.service;

import com.fishep.dragoon.domain.entity.*;
import com.fishep.dragoon.domain.factory.PlayerFactory;
import com.fishep.dragoon.domain.factory.WeaponFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EquipmentServiceOOPTest {

    @Autowired
    PlayerFactory playerFactory;

    @Autowired
    WeaponFactory weaponFactory;

    /**
     * 战士只能装备剑
     */
    @Test
    @DisplayName("Fighter Equipment Test")
    public void fighterEquipment() {
        Player fighter001 = playerFactory.createFighter("Fighter001");
        Weapon sword001 = weaponFactory.createSword("Sword001");
        Weapon staff001 = weaponFactory.createStaff("Staff001");

        assertTrue(fighter001.equipment(sword001));

        assertThrows(RuntimeException.class, () -> {
            fighter001.equipment(staff001);
        });
    }

    /**
     * 法师只能装备法杖
     */
    @Test
    @DisplayName("Mage Equipment Test")
    public void mageEquipment() {
        Mage mage001 = playerFactory.createMage("Mage001");
        Weapon sword001 = weaponFactory.createSword("Sword001");
        Weapon staff001 = weaponFactory.createStaff("Staff001");

        assertTrue(mage001.equipment(staff001));

        assertThrows(RuntimeException.class, () -> {
            mage001.equipment(sword001);
        });
    }

    /**
     * 龙骑随意装配
     */
    @Test
    @DisplayName("Dragoon Equipment Test")
    public void dragoonEquipment() {
        Dragoon dragoon001 = playerFactory.createDragoon("Dragoon001");
        Weapon sword001 = weaponFactory.createSword("Sword001");
        Weapon staff001 = weaponFactory.createStaff("Staff001");

        assertTrue(dragoon001.equipment(sword001));

        assertTrue(dragoon001.equipment(staff001));
    }

    /**
     * 只有战士和法师可以装备匕首（dagger）
     */
    @Test
    @DisplayName("Dagger Equipment Test")
    public void daggerEquipment() {
        Dagger dagger001 = weaponFactory.createDagger("Dagger001");
        Fighter fighter001 = playerFactory.createFighter("Fighter001");
        Mage mage001 = playerFactory.createMage("Mage001");
        Dragoon dragoon001 = playerFactory.createDragoon("Dragoon001");

        assertTrue(fighter001.equipment(dagger001));

        assertTrue(mage001.equipment(dagger001));

        assertThrows(RuntimeException.class, ()->{
            dragoon001.equipment(dagger001);
        });
    }
}
