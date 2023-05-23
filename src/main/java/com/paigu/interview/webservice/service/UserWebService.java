package com.paigu.interview.webservice.service;

import cn.hutool.core.collection.CollUtil;
import com.paigu.interview.webservice.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Service
@WebService(targetNamespace = "http://nmdidmsso.taiwanmobile.com")
public class UserWebService {
    @WebMethod(operationName = "reconciliationAccounts")
    public List<UserDTO> reconciliationAccounts() {
        return CollUtil.newArrayList(new UserDTO("liaoximing", "1"), new UserDTO("paigu", "1"), new UserDTO("wuxiyang", "0"));
    }

    @WebMethod(operationName = "changePassword")
    public Integer changePassword(@WebParam(name = "uid",targetNamespace = "http://nmdidmsso.taiwanmobile.com") String uid,@WebParam(name = "password",targetNamespace = "http://nmdidmsso.taiwanmobile.com") String password){
        return 1;
    }
}
