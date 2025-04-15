package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2024/12/18 18:20
 * @Desc
 **/
@Data
public class LoginCmd<U extends User> {

    public App app;

    public Class<U> user;

    public Identifier identifier;

    public Certificate certificate;

}
