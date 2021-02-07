package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    // 게시글 저장
    public void save(Board board) {
        em.persist(board);
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }

    // 전체 게시글 조회
    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }

    // 게시글 수정

    // 게시글 삭제
    public void delete(Board board) {
        em.remove(board);
    }

}
