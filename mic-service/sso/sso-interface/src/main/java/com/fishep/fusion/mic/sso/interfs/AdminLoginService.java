package com.fishep.fusion.mic.sso.interfs;

import com.fishep.fusion.mic.sso.interfs.req.auth.impl.AdminLoginReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.LoginRes;

/**
 * @Author fly.fei
 * @Date 2025/2/5 16:53
 * @Desc
 **/
public interface AdminLoginService {

    LoginRes login(AdminLoginReq req);

    LoginRes logout(AdminLoginReq req);

}
