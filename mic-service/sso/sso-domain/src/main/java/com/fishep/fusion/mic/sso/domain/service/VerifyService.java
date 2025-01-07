package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.Certificate;

import java.util.function.Supplier;

/**
 * @Author fly.fei
 * @Date 2024/12/26 17:43
 * @Desc 验证服务，验证标识符是否为用户所有，
 * 用户名: 注册就归其所有，不用验证
 * 邮箱：验证码验证通过则证明为其所有
 * 手机号: 验证码验证通过则证明为其所有
 **/
public interface VerifyService {

    /**
     * 验证逻辑
     * <p>
     * 用户名：归其所有
     * 邮箱+验证码，检查正确，则为其所有
     * 手机号+验证码，检查正确，则为其所有
     *
     * @param user
     * @param certificate
     * @return 标识符为用户所有则返回true, 否则返回false
     */
    boolean verify(User user, Certificate certificate);

    /**
     * 验证逻辑
     * <p>
     * 用户名：归其所有
     * 邮箱+验证码，检查正确，则为其所有
     * 手机号+验证码，检查正确，则为其所有
     *
     * @param user
     * @param supplier
     * @return 标识符为用户所有则返回true, 否则返回false
     */
    boolean verify(User user, Supplier<Certificate> supplier);

}
