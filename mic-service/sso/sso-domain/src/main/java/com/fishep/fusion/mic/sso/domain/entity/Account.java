package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.sso.domain.service.BindService;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author fly.fei
 * @Date 2025/4/1 15:05
 * @Desc 账号
 **/
@Getter
public class Account {

    //    标识符，表示一个唯一标识，可以是邮箱，电话号码，账号名
    protected Identifier identifier;

    //    凭证，可以是密码，验证码，
    protected Certificate certificate;

    //    激活状态
    @Setter
    protected Boolean activated;

    public Account(Identifier identifier) {
        if (identifier == null) {
            throw new ValidateException("The Account Identifier is null");
        }

        this.identifier = identifier;
    }

    public void bindCertificate(Certificate certificate, BindService bindService) {
        if (bindService.canUse(this, certificate)) {
            this.certificate = certificate;
            return;
        }

        throw new ValidateException("Unsupported bindCertificate");
    }

}
