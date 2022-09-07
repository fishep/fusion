package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.service.EquipmentService;
import com.fishep.dragoon.domain.type.PlayerId;

abstract public class Player {

    protected PlayerId id;

    protected String name;

    protected Weapon weapon;

    public Player(PlayerId id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean equipment(Weapon weapon, EquipmentService equipmentService){

        Boolean can = equipmentService.canEquipment(this, weapon);

        if (!can) {
            throw new RuntimeException("Player Equipment Exception");
        }

        this.weapon = weapon;

        return Boolean.TRUE;
    }

}
