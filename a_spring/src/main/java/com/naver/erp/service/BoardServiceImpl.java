package com.naver.erp.service;

import com.naver.erp.BoardDAO;
import com.naver.erp.BoardDTO;
import com.naver.erp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public int insertBoard(BoardDTO boardDTO) {

        int b_no = boardDTO.getB_no();

        if (b_no > 0) {
            int updatePrintNo
        }
        // boardRegCnt
        return this.boardDAO.insertBoard(boardDTO);
    }

    public List<Map<String, String>> getBoardList() {
        // boardList
        return this.boardDAO.getBoardList();
    }

    @Override
    public BoardDTO getBoard(int b_no) {
        BoardDTO board = this.boardDAO.getBoard(b_no);
        if (board != null) {
            int readcount = this.boardDAO.updateReadcount(b_no);
            boardDTO.setReadcount(board.getReadcount() + 1);
        }
        return board;
    }
}
