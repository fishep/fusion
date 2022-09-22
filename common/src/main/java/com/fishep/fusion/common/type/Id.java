package com.fishep.fusion.common.type;

import cn.hutool.core.util.IdUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Id {

    protected Long id;

    public Id() {
        this(IdUtil.getSnowflakeNextId());
    }

    static public Id generator() {
        return new Id(IdUtil.getSnowflakeNextId());
    }

}
