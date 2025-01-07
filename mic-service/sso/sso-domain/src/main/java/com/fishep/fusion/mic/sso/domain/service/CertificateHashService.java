package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.type.Certificate;

/**
 * @Author fly.fei
 * @Date 2024/12/23 12:05
 * @Desc 对凭证进行hash
 **/
public interface CertificateHashService {

    /**
     * 对凭证的明文进行hash处理
     *
     * @param certificate
     * @return hash之后的值
     */
    String hash(Certificate certificate);

}
