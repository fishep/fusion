package com.fishep.fusion.mic.sso.application.cqe;

import com.fishep.fusion.mic.sso.domain.entity.Supplier;
import com.fishep.fusion.mic.sso.domain.entity.User;
import com.fishep.fusion.mic.sso.domain.factory.CertificateFactory;
import com.fishep.fusion.mic.sso.domain.factory.IdentifierFactory;
import com.fishep.fusion.mic.sso.domain.service.AuthPairService;
import com.fishep.fusion.mic.sso.domain.service.CertificateHashService;
import com.fishep.fusion.mic.sso.domain.type.SupplierId;
import lombok.Data;

/**
 * @Author fly.fei
 * @Date 2024/12/26 10:31
 * @Desc
 **/
@Data
public class RegisterSupplierCmd extends RegisterCmd {

//    @NotBlank
//    public String userName;
//
//    @Email
//    public String email;
//
//    @NotBlank
//    public String phoneNumber;
//
//    @Size(min = 8, max = 32)
//    public String password;
//
//    @Size(min = 6, max = 6)
//    public String verificationCode;

    public String field;

    @Override
    public User getUser(AuthPairService authPairService, CertificateHashService certificateHashService) {
        Supplier supplier = new Supplier(new SupplierId(), IdentifierFactory.create(identifier));
        supplier.setAuthPair(CertificateFactory.create(password, certificateHashService), authPairService);
//        supplier.setField(field);

        return supplier;
    }

}
