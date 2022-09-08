package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.DamageType;
import com.fishep.dragoon.domain.type.WeaponId;

public class Dagger extends Weapon{

    public Dagger(WeaponId id, String name) {
        super(id, name);
    }

    public Dagger(WeaponId id, String name, Integer damage, DamageType damageType) {
        super(id, name, damage, damageType);
    }

    @Override
    protected Boolean haveFeature(DamageType damageType) {
        if (damageType == DamageType.PHYSICS)
        {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Boolean canEquipment(Player player) {
        return player instanceof Fighter || player instanceof Mage;
    }

}
