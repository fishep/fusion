package com.fishep.fusion.mic.sso.domain.type;

import cn.hutool.core.util.StrUtil;
import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2024/12/20 9:46
 * @Desc 标识符，表示一个唯一标识，可以是邮箱，电话号码，账号名
 **/
@Getter
public abstract class Identifier {

    protected String value;

    protected Identifier(String value) {

        if (StrUtil.isBlank(value)) {
            throw new ValidateException("The Identifier is Blank");
        }

        this.value = StrUtil.trim(value);
    }

}
