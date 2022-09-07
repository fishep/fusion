package com.fishep.dragoon.domain.factory;

import com.fishep.dragoon.domain.entity.Dragon;
import com.fishep.dragoon.domain.entity.Elf;
import com.fishep.dragoon.domain.entity.Orc;

public interface MonsterFactory {

    Orc createOrc(String name);

    Orc createOrc(String name, Integer blood);

    Elf createElf(String name);

    Elf createElf(String name, Integer blood);

    Dragon createDragon(String name);

    Dragon createDragon(String name, Integer blood);

}
