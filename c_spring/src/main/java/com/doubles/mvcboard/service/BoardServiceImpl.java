package com.doubles.mvcboard.service;

import java.util.List;
import java.util.Map;

import com.doubles.mvcboard.BoardDAO;
import com.doubles.mvcboard.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// [서비스 클래스]인 [LoginServiceImpl 클래스] 선언
	// [서비스 클래스]에는 @Service 와 @Transactional 를 붙인다.
	// @Service			=> [서비스 클래스] 임을 지정하고 bean 태그로 자동 등록된다.
	// @Transactional	=> [서비스 클래스]의 메소드 내부에서 일어나는 모든 작업에는 [트랜잭션]이 걸린다.
@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	
	//****************************************************
	// 속성변수 boardDAO 선언하고, [BoardDAO 인터페이스]를 구현한 클래스를 객체화해서 저장한다.
	//****************************************************
		// @Autowired 역할 -> 속성변수에 붙은 자료형인 [인터페이스]를 구현한 [클래스]를 객체화하여 저장한다.
	//****************************************************
	@Autowired
	private BoardDAO boardDAO;

	//****************************************************
	// [1개 게시판 글 입력 후 입력 적용 행의 개수] 리턴하는 메소드 선언
	//****************************************************
	public int insertBoard( BoardDTO boardDTO ) {
		
		System.out.println( "BoardServiceImpl.insertBoard 안으로 들어옴" );
		//------------------------------------------
		// BoardDAOImpl 객체의  insertBoard 메소드 호출하여 게시판 글 입력 후 입력 적용 행의 개수 얻기
		//------------------------------------------
		int boardRegCnt = this.boardDAO.insertBoard(boardDTO);
		System.out.println( "BoardServiceImpl.insertBoard 실행 성공" );
		//------------------------------------------
		// 1개 게시판 글 입력 적용 행의 개수 리턴하기
		//------------------------------------------
		return boardRegCnt;
	}
	//****************************************************
	// [검색한 게시판 목록] 리턴하는 메소드 선언
	//****************************************************
	public List<Map<String,String>> getBoardList( ){

		List<Map<String,String>> boardList = this.boardDAO.getBoardList( );
		return boardList;
	}

	//****************************************************
	// [1개 게시판 글] 리턴하는 메소드 선언
	//****************************************************
	public BoardDTO getBoard(int b_no) {

		
		/*
		//------------------------------------------
		// [BoardDAO 인터페이스]를 구현한 객체(=BoardDAOImpl)의 getBoard 메소드를 호출하여
		// [1개 게시판 글]을 얻는다
		//------------------------------------------
		BoardDTO board = this.boardDAO.getBoard(b_no);

		//------------------------------------------
		// [BoardDAOImpl 객체]의 updateReadcount 메소드를 호출하여
		// [조회수 증가]하고 수정한 행의 개수를 얻는다
		//------------------------------------------
		if( board!=null ){
			int readcount = this.boardDAO.updateReadcount(b_no);
			board.setReadcount(board.getReadcount()+1);
		}
		*/

		//------------------------------------------
		// [BoardDAOImpl 객체]의 updateReadcount 메소드를 호출하여
		// [조회수 증가]하고 수정한 행의 개수를 얻는다
		//------------------------------------------
		int updateCnt = this.boardDAO.updateReadcount(b_no);
		//------------------------------------------
		// 만약 수정 적용 행의 개수가 1이면
		// [BoardDAO 인터페이스]를 구현한 객체(=BoardDAOImpl)의 getBoard 메소드를 호출하여
		// [1개 게시판 글]을 얻는다
		//------------------------------------------
		BoardDTO board = null;
		if( updateCnt==1 ){
			board = this.boardDAO.getBoard(b_no);
		}
		//------------------------------------------
		// [1개 게시판 글]이 저장된 BoardDTO 객체 리턴하기
		//------------------------------------------
		return board;
	}
}
