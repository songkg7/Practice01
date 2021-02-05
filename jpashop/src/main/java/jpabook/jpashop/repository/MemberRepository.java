package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor // Spring Data JPA 에서는 가능한 방식
public class MemberRepository {

    //    @PersistenceContext
    private final EntityManager em;

    // 회원 영속화
    public void save(Member member) {
        em.persist(member);
    }

    // 회원 탈퇴
    public void delete(Member member) {
        em.remove(member);
    }

    // 회원 검색
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Optional<Member> findByEmail(String email) {

        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultStream().findAny();
    }

}
