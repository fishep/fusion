package com.fishep.dragoon.domain.factory.impl;

import com.fishep.dragoon.domain.entity.Dagger;
import com.fishep.dragoon.domain.entity.Staff;
import com.fishep.dragoon.domain.entity.Sword;
import com.fishep.dragoon.domain.factory.WeaponFactory;
import com.fishep.dragoon.domain.type.DamageType;
import com.fishep.dragoon.domain.type.WeaponId;
import org.springframework.stereotype.Component;

@Component
public class WeaponFactoryImpl implements WeaponFactory {
    @Override
    public Sword createSword(String name) {
        return this.createSword(name, 0, DamageType.PHYSICS);
    }

    @Override
    public Sword createSword(String name, Integer damage, DamageType damageType) {
        return new Sword(WeaponId.generate(), name, damage, damageType);
    }

    @Override
    public Staff createStaff(String name) {
        return this.createStaff(name, 0, DamageType.ICE);
    }

    @Override
    public Staff createStaff(String name, Integer damage, DamageType damageType) {
        return new Staff(WeaponId.generate(), name, damage, damageType);
    }

    @Override
    public Dagger createDagger(String name) {
        return this.createDagger(name, 0, DamageType.PHYSICS);
    }

    @Override
    public Dagger createDagger(String name, Integer damage, DamageType damageType) {
        return new Dagger(WeaponId.generate(), name, damage, damageType);
    }
}
