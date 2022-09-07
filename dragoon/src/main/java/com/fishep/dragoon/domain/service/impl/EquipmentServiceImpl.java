package com.fishep.dragoon.domain.service.impl;

import com.fishep.dragoon.domain.entity.Player;
import com.fishep.dragoon.domain.entity.Weapon;
import com.fishep.dragoon.domain.policy.EquipmentPolicy;
import com.fishep.dragoon.domain.policy.impl.DaggerEquipmentPolicy;
import com.fishep.dragoon.domain.policy.impl.FighterEquipmentPolicy;
import com.fishep.dragoon.domain.policy.impl.MageEquipmentPolicy;
import com.fishep.dragoon.domain.service.EquipmentService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipmentServiceImpl implements EquipmentService {

    static private List<EquipmentPolicy> policies;

    static {
        policies = new ArrayList<>();

        policies.add(new DaggerEquipmentPolicy());
        policies.add(new FighterEquipmentPolicy());
        policies.add(new MageEquipmentPolicy());
    }

    @Override
    public Boolean canEquipment(Player player, Weapon weapon) {

        for (EquipmentPolicy policy : policies)
        {
            if (!policy.canApply(player, weapon))
            {
                continue;
            }

            return policy.canEquip(player, weapon);
        }

        return Boolean.TRUE;
    }
}
