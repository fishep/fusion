package com.fishep.dragoon.domain.factory;

import com.fishep.dragoon.domain.entity.Dagger;
import com.fishep.dragoon.domain.entity.Staff;
import com.fishep.dragoon.domain.entity.Sword;
import com.fishep.dragoon.domain.type.DamageType;

public interface WeaponFactory {

    Sword createSword(String name);

    Sword createSword(String name, Integer damage, DamageType damageType);

    Staff createStaff(String name);

    Staff createStaff(String name, Integer damage, DamageType damageType);

    Dagger createDagger(String name);

    Dagger createDagger(String name, Integer damage, DamageType damageType);

}
