package com.fishep.fusion.mic.sso.interfs;

import com.fishep.fusion.mic.sso.interfs.req.auth.impl.AdminRegisterReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;

/**
 * @Author fly.fei
 * @Date 2025/2/5 16:49
 * @Desc
 **/
public interface AdminRegisterService {

    RegisterRes register(AdminRegisterReq req);

    RegisterRes deregister(AdminRegisterReq req);

}
