package com.fishep.fusion.mic.sso.interfs.service.auth;

import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;

/**
 * @Author fly.fei
 * @Date 2025/3/26 16:51
 * @Desc 注册服务，将用户标识和密码注册到系统
 **/
public interface RegisterService {

    RegisterRes register(RegisterReq req);

}
