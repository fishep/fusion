package com.fishep.dragoon.domain.policy.impl;

import com.fishep.dragoon.domain.entity.*;
import com.fishep.dragoon.domain.policy.CombatPolicy;

/**
 * 龙对物理和魔法攻击免疫，除非玩家是龙骑，则伤害加倍
 */

public class DragonCombatPolicy implements CombatPolicy {

    @Override
    public Integer calculateDamage(Player player, Weapon weapon, Monster monster) {
        if (player instanceof Dragoon)
        {
            Integer damage = weapon.getDamage();
            damage *= 2;
            return damage;
        }

        return 0;
    }

    @Override
    public Boolean canApply(Player player, Weapon weapon, Monster monster) {
        return monster instanceof Dragon;
    }

}
