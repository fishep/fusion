package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.PlayerId;

public class Dragoon extends Player{

    public Dragoon(PlayerId id, String name) {
        super(id, name);
    }

    @Override
    public Boolean canEquipment(Weapon weapon) {
        return Boolean.TRUE;
    }
}
