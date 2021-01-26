package com.naver.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public int updatePrintNo(BoardDTO boardDTO) {
        int updatePrintNoCnt = sqlSession.update(boardDTO);
    }

    public int insertBoard(BoardDTO boardDTO) {
        return sqlSession.insert("com.naver.erp.BoardDAO.insertBoard", boardDTO);
    }

    public List<Map<String,String>> getBoardList() {
        // boardList
        return this.sqlSession.selectList("com.naver.erp.BoardDAO.getBoardList");
    }

    // 1개 게시판 글 정보를 리턴하는 메소드 선언
    public BoardDTO getBoard(int b_no) {
        return this.sqlSession.selectOne("com.naver.erp.BoardDAO.getBoard", b_no);
    }

    public int updateReadcount(int b_no) {
        return this.sqlSession.update("com.naver.erp.BoardDAO.updateReadcount", b_no);
    }

}
