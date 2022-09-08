package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.PlayerId;

public class Mage extends Player{

    public Mage(PlayerId id, String name) {
        super(id, name);
    }

    @Override
    public Boolean canEquipment(Weapon weapon) {
        return weapon instanceof Staff || weapon instanceof Dagger;
    }
}
