package com.fishep.dragoon.domain.policy;

import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;

public interface EquipmentPolicy {

    Boolean canApply(Player player, Weapon weapon);

    Boolean canEquip(Player player, Weapon weapon);

}
