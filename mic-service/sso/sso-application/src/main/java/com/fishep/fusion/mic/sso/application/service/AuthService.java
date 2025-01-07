package com.fishep.fusion.mic.sso.application.service;

import com.fishep.fusion.mic.sso.application.cqe.ActivateCmd;
import com.fishep.fusion.mic.sso.application.cqe.LoginCmd;
import com.fishep.fusion.mic.sso.application.cqe.RegisterCmd;
import com.fishep.fusion.mic.sso.application.cqe.SendVerificationCodeCmd;
import com.fishep.fusion.mic.sso.application.dto.TokenDto;
import com.fishep.fusion.mic.sso.application.dto.VerificationCodeDto;

/**
 * @Author fly.fei
 * @Date 2024/12/18 18:09
 * @Desc 认证流程
 **/
public interface AuthService {

    void register(RegisterCmd registerCmd);

//    /**
//     * 注销用户，从系统中删除用户
//     *
//     * @param deregisterCmd
//     */
//    void deregister(DeregisterCmd deregisterCmd);

    /**
     * 发送验证码
     *
     * @param sendVerificationCodeCmd
     * @return
     */
    VerificationCodeDto sendVerificationCodeCmd(SendVerificationCodeCmd sendVerificationCodeCmd);

    /**
     * 激活用户，验证用户注册的信息的有效性，激活之后才能登录
     * 例如：通过往用户注册的邮箱发送一封邮件，通过用户点击邮箱里的链接，验证邮箱是用户所拥有的
     *
     * @param activateCmd
     */
    void activate(ActivateCmd activateCmd);

//    /**
//     * 钝化用户，使用户不可用，从系统软删除
//     *
//     * @param inactivateCmd
//     */
//    void inactivate(InactivateCmd inactivateCmd);

    /**
     * 用户登录，登录成功返回令牌，后续凭此令牌访问系统
     *
     * @param loginCmd
     * @return 成功返回令牌，失败返回null
     */
    TokenDto login(LoginCmd loginCmd);
//
//    /**
//     * 用户登出，退出登录，令牌作废
//     *
//     * @param logoutCmd
//     */
//    void logout(LogoutCmd logoutCmd);
//
//
//    /**
//     * 颁发令牌，后续可凭此令牌进行验证
//     *
//     * @param issueCmd
//     * @return 颁发成功返回Token，失败返回null
//     */
//    TokenDto issue(IssueCmd issueCmd);
//
//    /**
//     * 解析令牌，从令牌中解析出数据，包括用户数据，所属应用，版本号，等等
//     *
//     * @param parseCmd
//     * @return 解析成功返回Token，失败返回null
//     */
//    TokenDto parse(ParseCmd parseCmd);

}
