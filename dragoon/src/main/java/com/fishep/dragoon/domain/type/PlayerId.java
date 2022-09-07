package com.fishep.dragoon.domain.type;

import cn.hutool.core.util.IdUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerId {

    private Long id;

    static public PlayerId generate() {
        return new PlayerId(IdUtil.getSnowflakeNextId());
    }

}
