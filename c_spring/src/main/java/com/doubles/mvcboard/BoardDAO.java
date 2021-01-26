package com.doubles.mvcboard;

import java.util.List;
import java.util.Map;

// [DAO 인터페이스] 선언
public interface BoardDAO {

    // [게시판 글 입력 후 입력 적용 행의 개수] 리턴하는 메소드 선언
    int insertBoard(BoardDTO boardDTO);
    // [검색한 게시판 목록] 리턴하는 메소드 선언
    List<Map<String,String>> getBoardList( );
    // [1개의 게시판 정보]를 리턴하는 메소드 선언
    BoardDTO getBoard(int b_no);

    // 조회수 증가 하는 메소드 선언
    int updateReadcount(int b_no);

}

