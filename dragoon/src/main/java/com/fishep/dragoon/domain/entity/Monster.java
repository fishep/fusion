package com.fishep.dragoon.domain.entity;

import com.fishep.dragoon.domain.type.Health;
import com.fishep.dragoon.domain.type.MonsterId;

abstract public class Monster {

    protected MonsterId id;

    protected String name;

    protected Health health;

    public Monster(MonsterId id, String name) {
        this.id = id;
        this.name = name;
        this.health = new Health(0);
    }

    public Monster(MonsterId id, String name, Health health) {
        this.id = id;
        this.name = name;
        this.health = health;
    }

    public MonsterId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Health getHealth() {
        return health;
    }

    public void takeDamage(Integer damage){
        this.health.decrease(damage);
    }

}
