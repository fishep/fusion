package com.fishep.fusion.mic.sso.domain.entity;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.ddd.domain.type.Id;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Identifier;
import lombok.Getter;

/**
 * @Author fly.fei
 * @Date 2024/12/4 17:07
 * @Desc 表示一个用户
 **/
@Getter
public abstract class User {

    //    id 唯一id
    protected Id id;

    //    标识符，表示一个唯一标识，可以是邮箱，电话号码，账号名
    protected Identifier identifier;

    //    凭证，可以是密码，验证码，
    protected Certificate certificate;

    //    激活状态
    protected Boolean activated;

//    protected User() {
//        this.id = Id.generate();
//    }

    protected User(Id id) {
        if (id == null) {
            throw new ValidateException("The User Id is null");
        }

        this.id = id;
    }

//    protected User(Identifier identifier) {
//        if (identifier == null) {
//            throw new ValidateException("The User Identifier is null");
//        }
//
//        this.id = Id.generate();
//        this.identifier = identifier;
//    }

    protected User(Id id, Identifier identifier) {
        if (identifier == null) {
            throw new ValidateException("The User Identifier is null");
        }

        if (id == null) {
            throw new ValidateException("The User Id is null");
        }

        this.id = id;
        this.identifier = identifier;
    }

    public void setAuthPair(Identifier identifier, Certificate certificate, AuthPairService authPairService) {
        if (authPairService.canUse(this, identifier, certificate)) {
            this.identifier = identifier;
            this.certificate = certificate;
            return;
        }

        throw new ValidateException("Unsupported authentication method");
    }

    public void setAuthPair(Certificate certificate, AuthPairService authPairService) {
        if (authPairService.canUse(this, identifier, certificate)) {
            this.certificate = certificate;
            return;
        }

        throw new ValidateException("Unsupported authentication method");
    }

    public boolean isActivated() {
        return activated == null ? false : activated;
    }

    public void setActivated() {
        activated = Boolean.TRUE;
    }

}
