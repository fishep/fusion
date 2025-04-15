package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.Account;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Password;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2024/12/19 11:24
 * @Desc 注册命令，将标识符（用户名，邮箱，电话号码）和密码注册到系统
 **/
@Data
public class RegisterCmd {

    public App app;

    public Account account;

    public Password password;

}
