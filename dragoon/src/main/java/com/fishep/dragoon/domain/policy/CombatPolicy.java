package com.fishep.dragoon.domain.policy;

import com.fishep.dragoon.domain.entity.Monster;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;

public interface CombatPolicy {

    public Integer calculateDamage(Player player, Weapon weapon, Monster monster);

    public Boolean canApply(Player player, Weapon weapon, Monster monster);

}
