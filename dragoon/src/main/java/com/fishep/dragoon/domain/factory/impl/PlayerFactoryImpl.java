package com.fishep.dragoon.domain.factory.impl;

import com.fishep.dragoon.domain.entity.Dragoon;
import com.fishep.dragoon.domain.entity.Fighter;
import com.fishep.dragoon.domain.entity.Mage;
import com.fishep.dragoon.domain.factory.PlayerFactory;
import com.fishep.dragoon.domain.type.PlayerId;
import org.springframework.stereotype.Component;

@Component
public class PlayerFactoryImpl implements PlayerFactory {

    @Override
    public Fighter createFighter(String name) {
        Fighter fighter = new Fighter(PlayerId.generate(), name);

        return fighter;
    }

    @Override
    public Mage createMage(String name) {
        Mage mage = new Mage(PlayerId.generate(), name);

        return mage;
    }

    @Override
    public Dragoon createDragoon(String name) {
        Dragoon dragoon = new Dragoon(PlayerId.generate(), name);

        return dragoon;
    }
}
