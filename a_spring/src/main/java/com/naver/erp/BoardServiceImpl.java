package com.naver.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public int insertBoard(BoardDTO boardDTO) {

        // boardRegCnt
        return this.boardDAO.insertBoard(boardDTO);
    }
}
