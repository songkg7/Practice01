package com.naver.erp.service;

import com.naver.erp.BoardDTO;

import java.util.List;
import java.util.Map;

public interface BoardService {
    int insertBoard(BoardDTO boardDTO);

    List<Map<String, String>> getBoardList();
    BoardDTO getBoard(int b_no);
}
