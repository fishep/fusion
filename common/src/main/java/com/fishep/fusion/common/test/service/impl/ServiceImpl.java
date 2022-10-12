package com.fishep.fusion.common.test.service.impl;

import com.fishep.fusion.common.test.service.SayService;
import com.fishep.fusion.common.test.service.Service;
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
