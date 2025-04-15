package com.fishep.fusion.mic.sso.interfs.req.auth;

import cn.hutool.json.JSON;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/3/22 11:13
 * @Desc 生成授权码，可以给授权码绑定数据，在后续验证授权码的时候使用
 **/
@Data
public class GenerateAuthorizationCodeReq {

    public JSON body;

}
