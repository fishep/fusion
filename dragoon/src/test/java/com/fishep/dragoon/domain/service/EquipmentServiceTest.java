package com.fishep.dragoon.domain.service;

import com.fishep.dragoon.domain.entity.*;
import com.fishep.dragoon.domain.factory.PlayerFactory;
import com.fishep.dragoon.domain.factory.WeaponFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 限制条件：
 *     战士只能装备剑
 *     法师只能装备法杖
 */

@SpringBootTest
class EquipmentServiceTest {

    @Autowired
    PlayerFactory playerFactory;

    @Autowired
    WeaponFactory weaponFactory;

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 战士只能装备剑
     */
    @Test
    @DisplayName("Fighter Equipment Test")
    public void fighterEquipment() {
        Player player = playerFactory.createFighter("Fighter001");
        Weapon weaponSword = weaponFactory.createSword("Sword001");
        Weapon weaponStaff = weaponFactory.createStaff("Staff001");

        Boolean ret = player.equipment(weaponSword, equipmentService);
        assertTrue(ret);

        assertThrows(RuntimeException.class, () -> {
            player.equipment(weaponStaff, equipmentService);
        });
    }

    /**
     * 法师只能装备法杖
     */
    @Test
    @DisplayName("Mage Equipment Test")
    public void mageEquipment() {
        Player player = playerFactory.createMage("Mage001");
        Weapon weaponSword = weaponFactory.createSword("Sword001");
        Weapon weaponStaff = weaponFactory.createStaff("Staff001");

        Boolean ret = player.equipment(weaponStaff, equipmentService);
        assertTrue(ret);

        assertThrows(RuntimeException.class, () -> {
            player.equipment(weaponSword, equipmentService);
        });
    }

    /**
     * 龙骑随意装配
     */
    @Test
    @DisplayName("Dragoon Equipment Test")
    public void dragoonEquipment() {
        Player player = playerFactory.createDragoon("Dragoon001");
        Weapon weaponSword = weaponFactory.createSword("Sword001");
        Weapon weaponStaff = weaponFactory.createStaff("Staff001");

        Boolean ret1 = player.equipment(weaponSword, equipmentService);
        assertTrue(ret1);

        Boolean ret2 = player.equipment(weaponStaff, equipmentService);
        assertTrue(ret2);
    }

    /**
     * 玩家都能装备匕首（dagger）
     */
    @Test
    @DisplayName("Player Equipment Test")
    public void playerEquipment() {
        Dagger dagger001 = weaponFactory.createDagger("Dagger001");

        Fighter fighter001 = playerFactory.createFighter("Fighter001");
        Mage mage001 = playerFactory.createMage("Mage001");
        Dragoon dragoon001 = playerFactory.createDragoon("Dragoon001");

        assertTrue(fighter001.equipment(dagger001, equipmentService));
        assertTrue(mage001.equipment(dagger001, equipmentService));
        assertTrue(dragoon001.equipment(dagger001, equipmentService));
    }
}