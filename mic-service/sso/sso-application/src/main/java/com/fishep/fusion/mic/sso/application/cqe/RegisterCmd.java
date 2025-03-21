package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2024/12/19 11:24
 * @Desc 注册命令，将标识符（用户名，邮箱，电话号码）和密码注册到系统
 **/
@Data
public abstract class RegisterCmd {

    public String identifier;

    public String password;

    public abstract User getUser(AuthPairService authPairService, CertificateHashService certificateHashService);

}
