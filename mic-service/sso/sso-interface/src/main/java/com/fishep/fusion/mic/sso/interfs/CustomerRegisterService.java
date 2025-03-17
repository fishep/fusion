package com.fishep.fusion.mic.sso.interfs;

import com.fishep.fusion.mic.sso.interfs.req.auth.RegisterReq;
import com.fishep.fusion.mic.sso.interfs.res.auth.RegisterRes;

/**
 * @Author fly.fei
 * @Date 2025/2/5 16:54
 * @Desc
 **/
public interface CustomerRegisterService {

    RegisterRes register(RegisterReq req);

    RegisterRes deregister(RegisterReq req);

}
