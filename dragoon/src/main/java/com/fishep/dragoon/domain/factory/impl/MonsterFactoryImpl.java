package com.fishep.dragoon.domain.factory.impl;

import com.fishep.dragoon.domain.entity.Dragon;
import com.fishep.dragoon.domain.entity.Elf;
import com.fishep.dragoon.domain.entity.Orc;
import com.fishep.dragoon.domain.factory.MonsterFactory;
import com.fishep.dragoon.domain.type.Health;
import com.fishep.dragoon.domain.type.MonsterId;
import org.springframework.stereotype.Component;

@Component
public class MonsterFactoryImpl implements MonsterFactory {

    @Override
    public Orc createOrc(String name) {
        Orc orc = new Orc(MonsterId.generate(), name);

        return orc;
    }

    @Override
    public Orc createOrc(String name, Integer blood) {
        Orc orc = new Orc(MonsterId.generate(), name, new Health(blood));

        return orc;
    }

    @Override
    public Elf createElf(String name) {
        Elf elf = new Elf(MonsterId.generate(), name);

        return elf;
    }

    @Override
    public Elf createElf(String name, Integer blood) {
        Elf elf = new Elf(MonsterId.generate(), name, new Health(blood));

        return elf;
    }

    @Override
    public Dragon createDragon(String name) {
        Dragon dragon = new Dragon(MonsterId.generate(), name);

        return dragon;
    }

    @Override
    public Dragon createDragon(String name, Integer blood) {
        Dragon dragon = new Dragon(MonsterId.generate(), name, new Health(blood));

        return dragon;
    }
}
