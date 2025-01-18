package com.fishep.fusion.mic.sso.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2025/1/4 10:17
 * @Desc 验证信息
 **/
@Getter
@AllArgsConstructor
public class CertificateMessage {

    protected Identifier identifier;

    protected Certificate certificate;

}
