package com.fishep.dragoon.domain.type;

import cn.hutool.core.util.IdUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonsterId {

    private Long id;

    static public MonsterId generate() {
        return new MonsterId(IdUtil.getSnowflakeNextId());
    }

}
