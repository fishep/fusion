package com.fishep.dragoon.domain.service;

import com.fishep.dragoon.domain.entity.Monster;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;

public interface CombatService {

    void combat(Player player, Weapon weapon, Monster monster);

}
