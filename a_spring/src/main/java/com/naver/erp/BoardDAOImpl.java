package com.naver.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public int insertBoard(BoardDTO boardDTO) {
        return sqlSession.insert("com.naver.erp.BoardDAO.insertBoard", boardDTO);
    }
}
