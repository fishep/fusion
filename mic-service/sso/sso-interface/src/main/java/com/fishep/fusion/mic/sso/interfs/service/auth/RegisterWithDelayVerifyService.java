package com.fishep.fusion.mic.sso.interfs.service.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.ActivateReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterReq;
import com.fishep.fusion.mic.sso.interfs.req.auth.SendActivateCodeReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.ActivateRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;
import com.fishep.fusion.mic.sso.interfs.res.auth.SendActivateCodeRes;

/**
 * @Author fly.fei
 * @Date 2025/3/26 17:45
 * @Desc 注册服务，将用户标识和密码注册到系统，注册之后验证标识的有效性
 * 典型的过程如下，用户注册， 在用户提交注册的时候，给用户发送验证码，用户使用验证码激活
 **/
public interface RegisterWithDelayVerifyService {

    RegisterRes register(RegisterReq req);

    SendActivateCodeRes sendActivateCode(SendActivateCodeReq req);

    ActivateRes activate(ActivateReq req);
}
