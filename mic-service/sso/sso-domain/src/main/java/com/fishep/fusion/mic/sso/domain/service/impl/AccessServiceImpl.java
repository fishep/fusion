package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.ddd.domain.exception.ValidateException;
import com.fishep.fusion.mic.ddd.domain.service.BiEntityPolicy;
import com.fishep.fusion.mic.ddd.domain.service.BiEntityPolicyManager;
import com.fishep.fusion.mic.sso.domain.entity.Admin;
import com.fishep.fusion.mic.sso.domain.entity.Customer;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.service.AccessService;
import com.fishep.fusion.mic.sso.domain.type.App;
import com.fishep.fusion.mic.sso.domain.type.Back;
import com.fishep.fusion.mic.sso.domain.type.Mall;
import org.springframework.stereotype.Component;

/**
 * @Author fly.fei
 * @Date 2024/12/28 10:17
 * @Desc
 **/
@Component
public class AccessServiceImpl implements AccessService {

    private AccessManager manager = new AccessManager();

    @Override
    public void assertCanAccess(User user, App app) {
        if (!canAccess(user, app)) {
            throw new ValidateException("Users cannot access the application");
        }
    }

    @Override
    public boolean canAccess(User user, App app) {
        Boolean canAccess = manager.apply(user, app);
        return canAccess == null ? Boolean.FALSE : canAccess;
    }

    public class AccessManager extends BiEntityPolicyManager<User, App, Boolean, BiEntityPolicy<User, App, Boolean>> {
        {
            add(new BackPolicy());
            add(new MallPolicy());
            add(new OpenPolicy());
        }
    }

    /**
     * 后台访问策略，只允许Admin管理员访问
     */
    public class BackPolicy implements BiEntityPolicy<User, App, Boolean> {
        @Override
        public boolean test(User entity1, App entity2) {
            return entity2 instanceof Back;
        }

        @Override
        public Boolean apply(User entity1, App entity2) {
            return entity1 instanceof Admin;
        }
    }

    /**
     * 商城访问策略，允许Customer客户访问，允许Admin管理员访问
     */
    public class MallPolicy implements BiEntityPolicy<User, App, Boolean> {
        @Override
        public boolean test(User entity1, App entity2) {
            return entity2 instanceof Mall;
        }

        @Override
        public Boolean apply(User entity1, App entity2) {
            return entity1 instanceof Customer || entity1 instanceof Admin;
        }
    }

    /**
     * 开放访问策略，只允许以应用的身份访问
     */
    public class OpenPolicy implements BiEntityPolicy<User, App, Boolean> {
        @Override
        public boolean test(User entity1, App entity2) {
            return false;
        }

        @Override
        public Boolean apply(User entity1, App entity2) {
            return null;
        }
    }

}
