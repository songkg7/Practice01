package xproject.xshop.repository;

import org.springframework.stereotype.Repository;
import xproject.xshop.domain.Member;

import javax.persistence.*;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
