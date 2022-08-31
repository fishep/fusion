package com.fishep.fusion.user.common.type;

import cn.hutool.core.util.IdUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserId {
    private Long value;

    static public UserId generator(){
        long id = IdUtil.getSnowflakeNextId();

        return new UserId(id);
    }
}
