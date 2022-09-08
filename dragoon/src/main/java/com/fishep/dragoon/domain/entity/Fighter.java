package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.PlayerId;

public class Fighter extends Player{

    public Fighter(PlayerId id, String name) {
        super(id, name);
    }

    @Override
    public Boolean canEquipment(Weapon weapon) {
        return weapon instanceof Sword || weapon instanceof Dagger;
    }
}
