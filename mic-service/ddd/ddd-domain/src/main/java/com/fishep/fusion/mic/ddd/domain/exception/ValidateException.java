package com.fishep.fusion.mic.ddd.domain.exception;

import cn.hutool.core.util.StrUtil;

import java.io.Serial;

/**
 * @Author fly.fei
 * @Date 2024/12/5 17:15
 * @Desc 验证领域对象的参数不合法时抛出
 **/
public class ValidateException extends IllegalArgumentException {

    @Serial
    private static final long serialVersionUID = 4139433632721050037L;

    public ValidateException() {
    }

    public ValidateException(String s) {
        super(s);
    }

    public ValidateException(String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

}
