package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.ddd.domain.entity.App;
import com.fishep.fusion.mic.ddd.domain.entity.User;
import com.fishep.fusion.mic.ddd.domain.service.BiEntityPolicy;
import com.fishep.fusion.mic.ddd.domain.service.BiEntityPolicyManager;
import com.fishep.fusion.mic.sso.domain.entity.*;
import com.fishep.fusion.mic.sso.domain.service.GuardService;

/**
 * @Author fly.fei
 * @Date 2024/12/6 15:09
 * @Desc
 **/
public class GuardServiceGenericImpl implements GuardService {

    private GuardManager guardManager;

    {
        guardManager = new GuardManager();
    }

    @Override
    public Boolean canAccess(User user, App app) {

        Boolean canAccess = guardManager.apply(user, app);

        return canAccess == null ? Boolean.FALSE : canAccess;
    }


    public class GuardManager extends BiEntityPolicyManager<User, App, Boolean, BiEntityPolicy<User, App, Boolean>> {
        {
            add(new BackAccessPolicy());
            add(new MallAccessPolicy());
            add(new OpenAccessPolicy());
        }
    }

    /**
     * 后台应用访问策略，只允许Admin管理员访问
     */
    public class BackAccessPolicy implements BiEntityPolicy<User, App, Boolean> {
        @Override
        public boolean test(User user, App app) {
            return app instanceof Back;
        }

        @Override
        public Boolean apply(User user, App app) {
            return app instanceof Back && user instanceof Admin;
        }
    }

    /**
     * 商城应用访问策略，允许Customer客户访问，允许Admin管理员访问，允许Supplier供应商访问
     */
    public class MallAccessPolicy implements BiEntityPolicy<User, App, Boolean> {
        @Override
        public boolean test(User user, App app) {
            return app instanceof Mall;
        }

        @Override
        public Boolean apply(User user, App app) {
            return app instanceof Mall && (user instanceof Customer || user instanceof Admin || user instanceof Supplier);
        }
    }

    /**
     * 开放平台访问策略，只允许以应用的身份访问
     */
    public class OpenAccessPolicy implements BiEntityPolicy<User, App, Boolean> {
        @Override
        public boolean test(User user, App app) {
            return false;
        }

        @Override
        public Boolean apply(User user, App app) {
            return Boolean.FALSE;
        }
    }

}
