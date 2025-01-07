package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.Certificate;

import java.util.function.Supplier;

/**
 * @Author fly.fei
 * @Date 2024/12/26 17:43
 * @Desc 激活服务，激活用户
 **/
public interface ActivateService {

    /**
     * 邮箱+验证码，检查正确，激活
     * 手机号+验证码，检查正确，激活
     * <p>
     * 不符合激活条件，不激活
     * 符合激活条件，激活用户: 修改用户状态
     * <p>
     * 没有返回值，验证码验证错误抛异常
     *
     * @param user
     * @param certificate
     */
    void activate(User user, Certificate certificate);

    void activate(User user, Supplier<Certificate> supplier);

}
