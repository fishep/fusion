package com.fishep.fusion.mic.ddd.domain.type;

import cn.hutool.core.util.IdUtil;
import com.fishep.fusion.mic.ddd.domain.exception.ValidationException;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2024/12/5 11:42
 * @Desc 自增不连续，当运行多个实例时，小概率不唯一，当datacenterId + workerId一致时（1/1024的概率），在同一毫秒生成时，会重复
 **/
@Getter
public class Id {

    protected Long value;

    public Id() {
        this(IdUtil.getSnowflakeNextId());
    }

    public Id(Long value) {
        if (value <= 0) {
            throw new ValidationException("The ID value must be greater than 0");
        }

        this.value = value;
    }

    public static Id generate() {
        return new Id(IdUtil.getSnowflakeNextId());
    }

}
