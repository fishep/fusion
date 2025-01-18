package com.fishep.fusion.mic.sso.message;

import com.fishep.fusion.mic.sso.domain.type.CertificateMessage;

import java.util.concurrent.CompletableFuture;


/**
 * @Author fly.fei
 * @Date 2025/1/4 10:41
 * @Desc 发送验证信息
 **/
public interface CertificateMessageSender {

    CompletableFuture<Boolean> send(CertificateMessage certificateMessage);

}
