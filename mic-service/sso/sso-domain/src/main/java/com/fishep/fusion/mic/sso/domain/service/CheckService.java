package com.fishep.fusion.mic.sso.domain.service;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.Certificate;

import java.util.function.Supplier;

/**
 * @Author fly.fei
 * @Date 2024/12/19 16:58
 * @Desc 检查用户的凭证是否正确
 **/
public interface CheckService {

    /**
     * 检查用户的凭证是否正确
     *
     * @param user
     * @param certificate
     * @return 凭证正确返回true, 不正确返回false
     */
    boolean check(User user, Certificate certificate);

    /**
     * 检查用户的凭证是否正确
     *
     * @param user
     * @param supplier
     * @return 凭证正确返回true, 不正确返回false
     */
    boolean check(User user, Supplier<Certificate> supplier);

    /**
     * 检查凭证是否相等
     *
     * @param certificate1
     * @param certificate2
     * @return
     */
    boolean check(Certificate certificate1, Certificate certificate2);

    /**
     * 检查凭证是否相等
     *
     * @param certificate
     * @param supplier
     * @return
     */
    boolean check(Certificate certificate, Supplier<Certificate> supplier);

}
