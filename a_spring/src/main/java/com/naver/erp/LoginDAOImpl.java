package com.naver.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

// Repository 를 등록해서 bean tag 로 등
@Repository
public class LoginDAOImpl implements LoginDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public int getAdminIdCnt(Map<String, String> admin_id_pwd) {

        // mybatis 에게 DB 연동 지시하고 아이디, 암호의 존재 갯수를 얻기
//        System.out.println(admin_id_pwd.get("admin_id"));

        return this.sqlSession.selectOne("com.naver.erp.LoginDAO.getAdminIdCnt", admin_id_pwd);
    }
}
