package com.fishep.dragoon.domain.service.impl;

import com.fishep.dragoon.domain.entity.Monster;
import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;
import com.fishep.dragoon.domain.policy.CombatPolicy;
import com.fishep.dragoon.domain.policy.impl.DragonCombatPolicy;
import com.fishep.dragoon.domain.policy.impl.ElfCombatPolicy;
import com.fishep.dragoon.domain.policy.impl.OrcCombatPolicy;
import com.fishep.dragoon.domain.service.CombatService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CombatServiceImpl implements CombatService {

    static private List<CombatPolicy> policies;

    static {
        policies = new ArrayList<>();

        policies.add(new OrcCombatPolicy());
        policies.add(new ElfCombatPolicy());
        policies.add(new DragonCombatPolicy());
    }

    @Override
    public void combat(Player player, Weapon weapon, Monster monster) {
        for (CombatPolicy policy : policies){
            if (!policy.canApply(player, weapon, monster)){
                continue;
            }

            Integer damage = policy.calculateDamage(player, weapon, monster);
            monster.takeDamage(damage);
            return;
        }
    }
}
