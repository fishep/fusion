package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.Health;
import com.fishep.dragoon.domain.type.MonsterId;

public class Orc extends Monster{
    public Orc(MonsterId id, String name) {
        super(id, name);
    }

    public Orc(MonsterId id, String name, Health health) {
        super(id, name, health);
    }
}
