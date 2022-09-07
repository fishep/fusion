package com.fishep.dragoon.domain.service;

import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;

public interface EquipmentService {

    Boolean canEquipment(Player player, Weapon weapon);

}
