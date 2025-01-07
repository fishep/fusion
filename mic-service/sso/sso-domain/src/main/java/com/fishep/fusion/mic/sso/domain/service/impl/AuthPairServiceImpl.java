package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.ddd.domain.service.TeEntityPolicy;
import com.fishep.fusion.mic.ddd.domain.service.TeEntityPolicyManager;
import com.fishep.fusion.mic.sso.domain.entity.Admin;
import com.fishep.fusion.mic.sso.domain.entity.Customer;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.type.*;

/**
 * @Author fly.fei
 * @Date 2024/12/28 10:18
 * @Desc
 **/
public class AuthPairServiceImpl implements AuthPairService {

    private AuthPairManager manager = new AuthPairManager();

    @Override
    public boolean canUse(User user, Identifier identifier, Certificate certificate) {
        Boolean canUse = manager.apply(user, identifier, certificate);
        return canUse == null ? Boolean.FALSE : canUse;
    }

    public class AuthPairManager extends TeEntityPolicyManager<User, Identifier, Certificate, Boolean, TeEntityPolicy<User, Identifier, Certificate, Boolean>> {
        {
            add(new AdminPolicy());
            add(new CustomerPolicy());
        }
    }

    /**
     * 管理员 Admin   认证方式     用户名和密码
     */
    public class AdminPolicy implements TeEntityPolicy<User, Identifier, Certificate, Boolean> {
        @Override
        public boolean test(User entity1, Identifier entity2, Certificate entity3) {
            return entity1 instanceof Admin;
        }

        @Override
        public Boolean apply(User entity1, Identifier entity2, Certificate entity3) {
            return entity2 instanceof UserName && entity3 instanceof Password;
        }
    }

    /**
     * 客户 Customer   认证方式    邮箱和密码 || 邮箱和验证码 || 手机号和密码 || 手机号和验证码
     */
    public class CustomerPolicy implements TeEntityPolicy<User, Identifier, Certificate, Boolean> {
        @Override
        public boolean test(User entity1, Identifier entity2, Certificate entity3) {
            return entity1 instanceof Customer;
        }

        @Override
        public Boolean apply(User entity1, Identifier entity2, Certificate entity3) {
            return (entity2 instanceof Email && entity3 instanceof Password)
                || (entity2 instanceof Email && entity3 instanceof VerificationCode)
                || (entity2 instanceof PhoneNumber && entity3 instanceof Password)
                || (entity2 instanceof PhoneNumber && entity3 instanceof VerificationCode);
        }
    }

}
