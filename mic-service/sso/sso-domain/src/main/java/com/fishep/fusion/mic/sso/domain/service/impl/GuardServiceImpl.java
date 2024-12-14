package com.fishep.fusion.mic.sso.domain.service.impl;

import com.fishep.fusion.mic.ddd.domain.entity.App;
import com.fishep.fusion.mic.ddd.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.entity.*;
import com.fishep.fusion.mic.sso.domain.service.GuardService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author fly.fei
 * @Date 2024/12/6 10:43
 * @Desc
 **/
public class GuardServiceImpl implements GuardService {

    private GuardManager guardManager;

    {
        guardManager = new GuardManager();
    }

    @Override
    public Boolean canAccess(User user, App app) {

        Boolean canAccess = guardManager.canAccess(user, app);

        return canAccess == null ? Boolean.FALSE : canAccess;
    }

    /**
     * 守卫管理者，负责管理不同的访问策略
     */
    public class GuardManager {
        private final List<AccessPolicy> POLICIES = new ArrayList<>();

        {
            POLICIES.add(new MallAccessPolicy());
            POLICIES.add(new BackAccessPolicy());
            POLICIES.add(new OpenAccessPolicy());
        }

        public Boolean canAccess(User user, App app) {
            for (AccessPolicy policy : POLICIES) {
                if (!policy.canApply(user, app)) {
                    continue;
                }
                return policy.canAccess(user, app);
            }
            return null;
        }
    }

    /**
     * 访问策略
     */
    public interface AccessPolicy {

        /**
         * 是否可以应用此策略
         *
         * @param user 用户
         * @param app  应用系统
         * @return 可以使用此策略返回true，不能使用此策略返回false
         */
        boolean canApply(User user, App app);

        /**
         * 用户是否可以访问应用系统
         *
         * @param user 用户
         * @param app  应用系统
         * @return 如果可以访问返回true，如果不可以访问返回false，策略执行之后返回的对象，可以为null
         */
        Boolean canAccess(User user, App app);

    }

    /**
     * 后台应用访问策略，只允许Admin管理员访问
     */
    public class BackAccessPolicy implements AccessPolicy {
        @Override
        public boolean canApply(User user, App app) {
            return app instanceof Back;
        }

        @Override
        public Boolean canAccess(User user, App app) {
            return app instanceof Back && user instanceof Admin;
        }
    }

    /**
     * 商城应用访问策略，允许Customer客户访问，允许Admin管理员访问，允许Supplier供应商访问
     */
    public class MallAccessPolicy implements AccessPolicy {
        @Override
        public boolean canApply(User user, App app) {
            return app instanceof Mall;
        }

        @Override
        public Boolean canAccess(User user, App app) {
            return app instanceof Mall && (user instanceof Customer || user instanceof Admin || user instanceof Supplier);
        }
    }

    /**
     * 开放平台访问策略，只允许以应用的身份访问
     */
    public class OpenAccessPolicy implements AccessPolicy {
        @Override
        public boolean canApply(User user, App app) {
            return false;
        }

        @Override
        public Boolean canAccess(User user, App app) {
            return Boolean.FALSE;
        }
    }

}
