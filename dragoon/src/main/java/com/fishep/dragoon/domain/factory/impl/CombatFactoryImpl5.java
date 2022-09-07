package com.fishep.dragoon.domain.factory.impl;

import com.fishep.dragoon.domain.entity.Monster;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;
import com.fishep.dragoon.domain.factory.CombatFactory;
import com.fishep.dragoon.domain.factory.MonsterFactory;
import com.fishep.dragoon.domain.factory.PlayerFactory;
import com.fishep.dragoon.domain.factory.WeaponFactory;
import com.fishep.dragoon.domain.type.DamageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 龙骑持剑大战恶龙
 */

@Component
@Qualifier("DragoonSwordDragon")
public class CombatFactoryImpl5 implements CombatFactory {

    @Autowired
    private PlayerFactory playerFactory;

    @Autowired
    private WeaponFactory weaponFactory;

    @Autowired
    private MonsterFactory monsterFactory;

    @Override
    public Player createPlayer(String name) {
        return playerFactory.createDragoon(name);
    }

    @Override
    public Weapon createWeapon(String name) {
        return weaponFactory.createSword(name);
    }

    @Override
    public Weapon createWeapon(String name, Integer damage, DamageType damageType) {
        return weaponFactory.createSword(name, damage, damageType);
    }

    @Override
    public Monster createdMonster(String name) {
        return monsterFactory.createDragon(name);
    }

    @Override
    public Monster createdMonster(String name, Integer blood) {
        return monsterFactory.createDragon(name, blood);
    }
}
