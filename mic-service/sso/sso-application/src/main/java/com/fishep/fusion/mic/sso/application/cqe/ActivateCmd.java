package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.ActivateCode;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2024/12/19 11:26
 * @Desc
 **/
@Data
public class ActivateCmd<U extends User> {

    public App app;

    public Class<U> user;

    public Identifier identifier;

    public ActivateCode activateCode;

}
