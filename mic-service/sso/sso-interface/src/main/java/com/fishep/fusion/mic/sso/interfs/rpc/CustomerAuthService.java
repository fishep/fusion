package com.fishep.fusion.mic.sso.interfs.rpc;

/**
 * @Author fly.fei
 * @Date 2025/1/7 17:52
 * @Desc
 **/
public interface CustomerAuthService {

    void register(String email, String password);

    void register(String phoneNumber, String password, String verificationCode);

}
