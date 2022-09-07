package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.DamageType;
import com.fishep.dragoon.domain.type.WeaponId;

public class Staff extends Weapon{

    public Staff(WeaponId id, String name) {
        super(id, name);
    }

    public Staff(WeaponId id, String name, Integer damage, DamageType damageType) {
        super(id, name, damage, damageType);
    }

    @Override
    protected Boolean haveFeature(DamageType damageType) {
        if (damageType == DamageType.FIRE || damageType == DamageType.ICE){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
