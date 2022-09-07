package com.fishep.dragoon.domain.policy.impl;

import com.fishep.dragoon.domain.entity.Fighter;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Sword;
import com.fishep.dragoon.domain.entity.Weapon;
import com.fishep.dragoon.domain.policy.EquipmentPolicy;

public class FighterEquipmentPolicy implements EquipmentPolicy {
    @Override
    public Boolean canApply(Player player, Weapon weapon) {

        Boolean ret = player instanceof Fighter ? Boolean.TRUE : Boolean.FALSE;

        return ret;
    }

    @Override
    public Boolean canEquip(Player player, Weapon weapon) {

        boolean ret = player instanceof Fighter && weapon instanceof Sword;

        return ret;
    }
}
