package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2025/3/26 18:01
 * @Desc
 **/
@Data
public class SendActivateCodeCmd<T extends Account> {

    public App app;

    public Class<T> accountClass;

    public Identifier identifier;

}
