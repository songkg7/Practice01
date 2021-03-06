package com.naver.erp;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
    int insertBoard(BoardDTO boardDTO);

    List<Map<String, String>> getBoardList();

    BoardDTO getBoard(int b_no);

    int updateReadcount(int b_no);
}
