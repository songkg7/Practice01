package jpabook.jpashop.service;

import jpabook.jpashop.domain.Board;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void create() {
        // given
        Member member = new Member();
        Board board = Board.createBoard(member, "Title", "Lorem it sum...");

        // when
        boardRepository.save(board);

        // then
        assertEquals(board.getSubject(), "Title");
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {

    }

}