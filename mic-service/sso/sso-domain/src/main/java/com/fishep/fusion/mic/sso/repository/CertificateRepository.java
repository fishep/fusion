package com.fishep.fusion.mic.sso.repository;

import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.type.Certificate;
import com.fishep.fusion.mic.sso.domain.type.Identifier;

/**
 * @Author fly.fei
 * @Date 2024/12/26 17:12
 * @Desc
 **/
public interface CertificateRepository {

    <U extends User, C extends Certificate> Certificate find(Class<U> userClass, Identifier identifier, Class<C> certificateClass);

    <U extends User> boolean save(Class<U> userClass, Identifier identifier, Certificate certificate);

}
