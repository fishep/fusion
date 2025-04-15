package com.fishep.fusion.mic.sso.application.cqe;

import cn.hutool.json.JSON;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.App;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/3/22 11:13
 * @Desc 生成授权码，可以给授权码绑定数据，在后续验证授权码的时候使用
 **/
@Data
public class GenerateAuthorizationCodeCmd {

    public User operator;

    public App app;

    public JSON body;

}
