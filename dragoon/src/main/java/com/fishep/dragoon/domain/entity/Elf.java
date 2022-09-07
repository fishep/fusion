package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.Health;
import com.fishep.dragoon.domain.type.MonsterId;

public class Elf extends Monster{

    public Elf(MonsterId id, String name) {
        super(id, name);
    }

    public Elf(MonsterId id, String name, Health health) {
        super(id, name, health);
    }

}
