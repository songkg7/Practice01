package com.doubles.mvcboard.service;

import com.doubles.mvcboard.BoardDTO;

import java.util.*;

//[BoardService 인터페이스] 선언
public interface BoardService {
	//****************************************************
	// [게시판 글 입력 후 입력 적용 행의 개수] 리턴하는 메소드 선언
	//****************************************************
	int insertBoard(BoardDTO boardDTO);

	//****************************************************
	// [검색한 게시판 목록] 리턴하는 메소드 선언
	//****************************************************
	List<Map<String,String>> getBoardList( );

	//****************************************************
	// [1개 게시판 글] 리턴하는 메소드 선언
	//****************************************************
	BoardDTO getBoard(int b_no);
}

