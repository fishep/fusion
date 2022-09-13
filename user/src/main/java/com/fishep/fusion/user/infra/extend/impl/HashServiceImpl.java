package com.fishep.fusion.user.infra.extend.impl;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import com.fishep.fusion.user.domain.extend.HashService;
import org.springframework.stereotype.Service;

@Service
public class HashServiceImpl implements HashService {
    @Override
    public String hash(String data) {
        HMac mac = new HMac(HmacAlgorithm.HmacMD5, data.getBytes());

        return mac.digestHex(data);
    }
}
