package com.fishep.dragoon.domain.policy.impl;

import com.fishep.dragoon.domain.entity.Mage;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Staff;
import com.fishep.dragoon.domain.entity.Weapon;
import com.fishep.dragoon.domain.policy.EquipmentPolicy;

public class MageEquipmentPolicy implements EquipmentPolicy {
    @Override
    public Boolean canApply(Player player, Weapon weapon) {

        Boolean ret = player instanceof Mage ? Boolean.TRUE : Boolean.FALSE;

        return ret;
    }

    @Override
    public Boolean canEquip(Player player, Weapon weapon) {

        boolean ret = player instanceof Mage && weapon instanceof Staff;

        return ret;
    }
}
