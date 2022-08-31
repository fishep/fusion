package com.fishep.fusion.user.infra.extend.impl;

import com.fishep.fusion.user.domain.extend.HashService;
import org.springframework.stereotype.Service;

@Service
public class HashServiceImpl implements HashService {
    @Override
    public String hash(String data) {
        return "********";
    }
}
