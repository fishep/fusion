package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.DamageType;
import com.fishep.dragoon.domain.type.WeaponId;

abstract public class Weapon {

    protected WeaponId id;

    protected String name;

    protected Integer damage;

    protected DamageType damageType;

    public Weapon(WeaponId id, String name) {
        this.id = id;
        this.name = name;
    }

    public Weapon(WeaponId id, String name, Integer damage, DamageType damageType) {

        if (!this.haveFeature(damageType)){
            throw new RuntimeException(this.getName() + " not damage type" + damageType);
        }

        this.id = id;
        this.name = name;
        this.damage = damage;
        this.damageType = damageType;
    }

    public WeaponId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDamage() {
        return damage;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    abstract protected Boolean haveFeature(DamageType damageType);

    abstract public Boolean canEquipment(Player player);
}
