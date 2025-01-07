package com.fishep.fusion.mic.sso.domain.service.exception;

import cn.hutool.core.util.StrUtil;

/**
 * @Author fly.fei
 * @Date 2024/12/5 17:15
 * @Desc
 **/
public class CertificateException extends RuntimeException {

    public CertificateException() {
    }

    public CertificateException(String s) {
        super(s);
    }

    public CertificateException(String messageTemplate, Object... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public CertificateException(Throwable cause) {
        super(cause);
    }

    public CertificateException(String message, Throwable cause) {
        super(message, cause);
    }

}
