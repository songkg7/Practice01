package com.doubles.mvcboard;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// [DAO 클래스]인 [LoginDAOImpl 클래스] 선언
	// @Repository 를 붙임으로써 [DAO 클래스]임을 지정하게되고,
	// bean 태그로 자동 등록된다.
@Repository
public class LoginDAOImpl implements LoginDAO{

	//+++++++++++++++++++++++++++++++++++++++
	// SqlSessionTemplate 객체를 생성해 속변 sqlSession 에 저장
	// @Autowired 어노테이션을 붙이면 자료형에 맞는 SqlSessionTemplate 객체를 생성한다.
	//+++++++++++++++++++++++++++++++++++++++
	@Autowired
	private SqlSessionTemplate sqlSession;

	//+++++++++++++++++++++++++++++++++++++++
	// 로그인 정보의 개수를 리턴하는 메소드 선언
	//+++++++++++++++++++++++++++++++++++++++
	public int getAdminIdCnt( 
		//---------------------------------------------------
		// 매개변수로 클이 입력한 아이디와 암호가 저장된 HashMap 객체가 들어온다.
		// <참고>Map 인터페이스를 구현한 클래스가 HashMap 클래스이다.
		//       그러므로 HashMap 객체가 들어와도 자료형은 Map 을 쓸수 있다.
		//---------------------------------------------------
		Map<String,String> admin_id_pwd 
	) {
		//--------------------------------------------------
		// SqlSessionTemplate 객체의 selectOne 메소드 호출로
		// mybatis 프레임워크가 관리하는 SQL구문을 호출하여 
		// 1행의 데이터인  [로그인 아이디,암호 존재 개수]를 얻기
		//--------------------------------------------------
		//--------------------------------------------------
		// selectOne( "com.naver.erp.LoginDAO.getAdminCnt" , admin_id_pwd ); 의미
		//--------------------------------------------------
			// mybatis SQL 구문 설정 XML 파일(=mapper_login.xml) 에서
			// <mapper namespace="com.naver.erp.LoginDAO"> 태그 내부의
			// <select id="getAdminCnt" ~> 태그 내부의
			// [1행 리턴 select 쿼리문]을 실행하고 얻은 데이터를 int로 리턴한다.
			// 2번째 인자는 [1행 리턴 select 쿼리문]에 삽입될 데이터이다.
			// 리턴 자료형은 무조건 int 이다.
		int adminCnt = this.sqlSession.selectOne(
					"com.naver.erp.LoginDAO.getAdminIdCnt"  //  xml 파일 내부의  select문이 있는 곳의 위치
					,admin_id_pwd
		);
		return adminCnt;
	}

}
