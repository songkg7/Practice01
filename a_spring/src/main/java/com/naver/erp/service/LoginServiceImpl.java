package com.naver.erp.service;

import com.naver.erp.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

// 서비스 클래스 LoginServiceImpl Class description
// Service Class 에는 @Service 와 @Transactional 을 붙인다.
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;

    public int getAdminIdCnt(Map<String, String> admin_id_pwd) {
        return this.loginDAO.getAdminIdCnt(admin_id_pwd);
    }


}
