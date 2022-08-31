package com.fishep.fusion.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    // 1000 以下保持和http的状态码一致， 1000 以上为自定义状态码
    private Integer code;

    private String message;

    private T data;

    public Result(Integer code) {
        this(code, "success");
    }

    public Result(String message) {
        this(200, message);
    }

    public Result(T data) {
        this(200, "success", data);
    }

    public Result(Integer code, String message) {
        this(code, message, null);
    }
}
