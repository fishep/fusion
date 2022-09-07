package com.fishep.dragoon.domain.policy.impl;

import com.fishep.dragoon.domain.entity.Monster;
import com.fishep.dragoon.domain.entity.Orc;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;
import com.fishep.dragoon.domain.policy.CombatPolicy;
import com.fishep.dragoon.domain.type.DamageType;

/**
 * 兽人对物理攻击伤害减半
 */

public class OrcCombatPolicy implements CombatPolicy {

    @Override
    public Integer calculateDamage(Player player, Weapon weapon, Monster monster) {
        Integer damage = weapon.getDamage();

        if (weapon.getDamageType() == DamageType.PHYSICS){
            damage /= 2;
        }

        return damage;
    }

    @Override
    public Boolean canApply(Player player, Weapon weapon, Monster monster) {
        return monster instanceof Orc;
    }

}
