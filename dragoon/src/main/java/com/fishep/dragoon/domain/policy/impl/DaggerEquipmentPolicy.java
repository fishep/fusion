package com.fishep.dragoon.domain.policy.impl;

import com.fishep.dragoon.domain.entity.Dagger;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;
import com.fishep.dragoon.domain.policy.EquipmentPolicy;

public class DaggerEquipmentPolicy implements EquipmentPolicy {

    @Override
    public Boolean canApply(Player player, Weapon weapon) {
        return weapon instanceof Dagger;
    }

    @Override
    public Boolean canEquip(Player player, Weapon weapon) {
        return Boolean.TRUE;
    }
}
