package com.fishep.dragoon.domain.type;

import cn.hutool.core.util.IdUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeaponId {

    private Long id;

    static public WeaponId generate(){
        return new WeaponId(IdUtil.getSnowflakeNextId());
    }

}
