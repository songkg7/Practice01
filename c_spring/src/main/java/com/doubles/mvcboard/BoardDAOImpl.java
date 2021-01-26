package com.doubles.mvcboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// [DAO 클래스]인 [BoardDAOImpl 클래스] 선언
	// @Repository 를 붙임으로써 [DAO 클래스]임을 지정하게되고, bean 태그로 자동 등록된다.
@Repository
public class BoardDAOImpl implements BoardDAO{
	//****************************************************
	// 속변 sqlSession 선언하고, [SqlSessionTemplate 객체]를 생성해 저장
	//****************************************************
		// @Autowired 역할 -> 속성변수에 붙은 자료형이 [인터페이스]면 이를 구현한 [클래스]를 객체화하여 저장한다.
		// @Autowired 역할 -> 속성변수에 붙은 자료형이 [클래스]면 이를 객체화하여 저장한다.
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//****************************************************
	// [게시판 글 입력 후 입력 적용 행의 개수]를 리턴하는 메소드 선언
	//****************************************************
	public int insertBoard(BoardDTO boardDTO) {

		System.out.println( "BoardDAOImpl.insertBoard 안으로 들어옴" );
		//--------------------------------
		// SqlSessionTemplate 객체의 insert 메소드 호출로 
		// 게시판 글 입력 SQL 구문을 실행하고 입력 성공 행의 개수얻기
		//--------------------------------
		//**************************************
		// insert( "com.naver.erp.BoardDAO.insertBoard" , boardDTO ); 의미
		//**************************************
			// mybatis SQL 구문 설정 XML 파일 에서
			// <mapper namespace="com.naver.erp.BoardDAO"> 태그 내부의
			// <insert id="insertBoard" ~> 태그 내부의
			// [insert 쿼리문]을 실행하고 입려 성공행의 개수를 얻기
		int boardRegCnt = sqlSession.insert(
					"com.doubles.mvcboard.BoardDAO.insertBoard"	// 실행할 SQL 구문의 위치 지정
					,boardDTO								// 실행할 SQL 구문에서 사용할 데이터 지정
		);
		System.out.println( "BoardDAOImpl.insertBoard 실행 성공" );


		return boardRegCnt;
	}
	//****************************************************
	// [검색한 게시판 목록] 리턴하는 메소드 선언
	//****************************************************
	public List<Map<String,String>> getBoardList( ){
		List<Map<String,String>> boardList = this.sqlSession.selectList(
				"com.doubles.mvcboard.BoardDAO.getBoardList"	// 실행할 SQL 구문의 위치 지정
		);
		return boardList;
	}

	//****************************************************
	// [1개 게시판 글 정보] 리턴하는 메소드 선언
	//****************************************************
	public BoardDTO getBoard(int b_no) {
		//-------------------------------------------------------
		// [SqlSessionTemplate 객체]의 selectOne(~,~) 를 호출하여 [1개 게시판 글 정보] 얻기
		//-------------------------------------------------------
		BoardDTO board = this.sqlSession.selectOne(
				"com.doubles.mvcboard.BoardDAO.getBoard"	// 실행할 SQL 구문의 위치 지정
				,b_no								// 실행할 SQL 구문에서 사용할 데이터 지정
		);
		//-------------------------------------------------------
		// [1개 게시판 글 정보] 리턴하기
		//-------------------------------------------------------
		return board;
	}

	//****************************************************
	// [게시판 글 조회수 증가하고 수정행의 개수] 리턴하는 메소드 선언
	//****************************************************
	public int updateReadcount(int b_no) {
		//-------------------------------------------------------
		// [SqlSessionTemplate 객체]의 update(~,~) 를 호출하여 [조회수 증가]하기
		//-------------------------------------------------------
		int updateCnt = this.sqlSession.update(
				"com.doubles.mvcboard.BoardDAO.updateReadcount"// 실행할 SQL 구문의 위치 지정
				,b_no									// 실행할 SQL 구문에서 사용할 데이터 지정
		);
		return updateCnt;
	}

}