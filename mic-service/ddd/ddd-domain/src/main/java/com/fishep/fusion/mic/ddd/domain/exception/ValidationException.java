package com.fishep.fusion.mic.ddd.domain.exception;

import java.io.Serial;

/**
 * @Author fly.fei
 * @Date 2024/12/5 17:15
 * @Desc 验证领域对象的参数不合法时抛出
 **/
public class ValidationException extends IllegalArgumentException {

    @Serial
    private static final long serialVersionUID = 4139433632721050037L;

    public ValidationException(String s) {
        super(s);
    }

}
