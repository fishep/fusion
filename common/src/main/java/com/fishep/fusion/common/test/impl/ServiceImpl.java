package com.fishep.fusion.common.test.impl;

import com.fishep.fusion.common.test.SayService;
import com.fishep.fusion.common.test.Service;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImpl implements Service {

    @Autowired
    SayService sayService;

    @Override
    public String say(String word) {
        return sayService.say(word);
    }

    @Override
    public String sayWelcome() {
        return sayService.sayWelcome();
    }

    @Override
    public void sayNothing() {
        sayService.sayNothing();
    }
}
