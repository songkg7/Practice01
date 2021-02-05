package jpabook.jpashop.service;

import jpabook.jpashop.domain.Board;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시물 작성
    @Transactional
    public void create(Member member, String subject, String mainText) {
        Board board = Board.createBoard(member, subject, mainText);

        boardRepository.save(board);
    }

    @Transactional
    public void update(Long boardId, String subject, String mainText) {
        Board board = boardRepository.findOne(boardId);
        board.setSubject(subject);
        board.setMainText(mainText);

        // save 명령은 불필요하다
//        boardRepository.save(board);

    }

    @Transactional
    public void updateViewCount(Long boardId) {
        Board board = boardRepository.findOne(boardId);
        board.setViewCount(board.getViewCount() + 1);
    }

    public List<Board> findBoard() {
        return boardRepository.findAll();
    }

    public Board findOne(Long boardId) {
        return boardRepository.findOne(boardId);
    }

}
