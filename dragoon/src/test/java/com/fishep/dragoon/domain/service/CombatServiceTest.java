package com.fishep.dragoon.domain.service;

import com.fishep.dragoon.domain.entity.*;
import com.fishep.dragoon.domain.factory.CombatFactory;
import com.fishep.dragoon.domain.type.DamageType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 攻击规则如下：
 *     兽人对物理攻击伤害减半
 *     精灵对魔法攻击伤害减半
 *     龙对物理和魔法攻击免疫，除非玩家是龙骑，则伤害加倍
 */

@SpringBootTest
class CombatServiceTest {

    @Autowired
    @Qualifier("DragoonSwordOrc")
    CombatFactory combatFactory1;

    @Autowired
    @Qualifier("DragoonStaffOrc")
    CombatFactory combatFactory2;

    @Autowired
    @Qualifier("DragoonSwordElf")
    CombatFactory combatFactory3;

    @Autowired
    @Qualifier("DragoonStaffElf")
    CombatFactory combatFactory4;

    @Autowired
    @Qualifier("DragoonSwordDragon")
    CombatFactory combatFactory5;

    @Autowired
    @Qualifier("DragoonStaffDragon")
    CombatFactory combatFactory6;

    @Autowired
    @Qualifier("FighterSwordDragon")
    CombatFactory combatFactory7;

    @Autowired
    @Qualifier("MageStaffDragon")
    CombatFactory combatFactory8;

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    CombatService combatService;

    /**
     * 龙骑持剑大战兽人 兽人对物理攻击伤害减半
     * 龙骑持法杖大战兽人 兽人对魔法攻击伤害正常
     */
    @Test
    void attackOrc() {
        Integer damage = 6;
        Integer blood  = 10;

        Player player = combatFactory1.createPlayer("Dragoon001");
        Weapon weapon = combatFactory1.createWeapon("Sword001", damage, DamageType.PHYSICS);
        Monster monster = combatFactory1.createdMonster("Orc001", blood);

        player.equipment(weapon, equipmentService);

        assertEquals(damage, weapon.getDamage());
        assertEquals(blood, monster.getHealth().getBlood());

        System.out.println(player.getName() + " equipment " + weapon.getName() + " Combat " + monster.getName());
        combatService.combat(player, weapon, monster);
        assertEquals(blood - damage / 2, monster.getHealth().getBlood());
        System.out.println("Combat Case1 Over");

        blood = monster.getHealth().getBlood();
        Weapon weaponStaff = combatFactory2.createWeapon("Staff001", damage, DamageType.ICE);
        player.equipment(weaponStaff, equipmentService);
        System.out.println(player.getName() + " equipment " + weaponStaff.getName() + " Combat " + monster.getName());
        combatService.combat(player, weaponStaff, monster);
        assertEquals(blood - damage, monster.getHealth().getBlood());
        System.out.println("Combat Case2 Over");
    }

    /**
     * 龙骑持剑大战精灵 精灵对魔法攻击伤害正常
     * 龙骑持法杖大战精灵 精灵对魔法攻击伤害减半
     */
    @Test
    void attackElf() {
        Integer damage = 6;
        Integer blood  = 10;

        Player dragoon002 = combatFactory3.createPlayer("Dragoon002");
        Weapon sword002 = combatFactory3.createWeapon("Sword002", damage, DamageType.PHYSICS);
        Monster elf002 = combatFactory3.createdMonster("Elf002", blood);
        dragoon002.equipment(sword002, equipmentService);

        System.out.println(dragoon002.getName() + " equipment " + sword002.getName() + " Combat " + elf002.getName());
        combatService.combat(dragoon002, sword002, elf002);
        assertEquals(blood - damage, elf002.getHealth().getBlood());

        blood = elf002.getHealth().getBlood();
        Weapon staff002 = combatFactory4.createWeapon("Staff002", damage, DamageType.FIRE);
        dragoon002.equipment(staff002, equipmentService);

        System.out.println(dragoon002.getName() + " equipment " + staff002.getName() + " Combat " + elf002.getName());
        combatService.combat(dragoon002, staff002, elf002);
        assertEquals(blood - damage / 2, elf002.getHealth().getBlood());
    }

    /**
     * 龙骑持剑大战恶龙    龙对物理和魔法攻击免疫，除非玩家是龙骑，则伤害加倍
     * 龙骑持法杖大战恶龙  龙对物理和魔法攻击免疫，除非玩家是龙骑，则伤害加倍
     * 战士持剑大战恶龙    龙对物理和魔法攻击免疫，除非玩家是龙骑，则伤害加倍
     * 法师持法杖大战恶龙  龙对物理和魔法攻击免疫，除非玩家是龙骑，则伤害加倍
     */
    @Test
    void attackDragon() {
        Integer damage = 1;
        Integer blood  = 10;

        Player dragoon001 = combatFactory5.createPlayer("Dragoon001");
        Weapon sword001 = combatFactory5.createWeapon("Sword001", damage, DamageType.PHYSICS);
        Monster dragon001 = combatFactory5.createdMonster("Dragon001", blood);
        dragoon001.equipment(sword001, equipmentService);

        combatService.combat(dragoon001, sword001, dragon001);

        assertEquals(blood - 2 * damage, dragon001.getHealth().getBlood());

        blood = dragon001.getHealth().getBlood();
        Weapon staff001 = combatFactory6.createWeapon("Staff001", damage, DamageType.ICE);
        dragoon001.equipment(staff001, equipmentService);

        combatService.combat(dragoon001, staff001, dragon001);

        assertEquals(blood - 2 * damage, dragon001.getHealth().getBlood());

        blood = dragon001.getHealth().getBlood();
        Player fighter001 = combatFactory7.createPlayer("Fighter001");
        fighter001.equipment(sword001, equipmentService);

        combatService.combat(fighter001, sword001, dragon001);

        assertEquals(blood, dragon001.getHealth().getBlood());

        Player mage001 = combatFactory8.createPlayer("Mage001");
        mage001.equipment(staff001, equipmentService);

        combatService.combat(mage001, staff001, dragon001);

        assertEquals(blood, dragon001.getHealth().getBlood());
    }

}