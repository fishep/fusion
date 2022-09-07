package com.fishep.dragoon.domain.factory;

import com.fishep.dragoon.domain.entity.Dragoon;
import com.fishep.dragoon.domain.entity.Fighter;
import com.fishep.dragoon.domain.entity.Mage;

public interface PlayerFactory {

    Fighter createFighter(String name);

    Mage createMage(String name);

    Dragoon createDragoon(String name);

}
