package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.Health;
import com.fishep.dragoon.domain.type.MonsterId;

public class Dragon extends Monster{

    public Dragon(MonsterId id, String name) {
        super(id, name);
    }

    public Dragon(MonsterId id, String name, Health health) {
        super(id, name, health);
    }
}
