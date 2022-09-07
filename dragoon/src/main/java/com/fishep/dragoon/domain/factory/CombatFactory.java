package com.fishep.dragoon.domain.factory;

import com.fishep.dragoon.domain.entity.Monster;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;
import com.fishep.dragoon.domain.type.DamageType;

public interface CombatFactory {

    Player createPlayer(String name);

    Weapon createWeapon(String name);

    Weapon createWeapon(String name, Integer damage, DamageType damageType);

    Monster createdMonster(String name);

    Monster createdMonster(String name, Integer blood);

}
