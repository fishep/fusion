package com.fishep.dragoon.domain.policy.impl;

import com.fishep.dragoon.domain.entity.Elf;
import com.fishep.dragoon.domain.entity.Monster;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;
import com.fishep.dragoon.domain.policy.CombatPolicy;
import com.fishep.dragoon.domain.type.DamageType;

/**
 * 精灵对魔法攻击伤害减半
 */

public class ElfCombatPolicy implements CombatPolicy {

    @Override
    public Integer calculateDamage(Player player, Weapon weapon, Monster monster) {
        Integer damage = weapon.getDamage();

        if (weapon.getDamageType() == DamageType.ICE || weapon.getDamageType() == DamageType.FIRE){
            damage /= 2;
        }

        return damage;
    }

    @Override
    public Boolean canApply(Player player, Weapon weapon, Monster monster) {
        return monster instanceof Elf;
    }
}
