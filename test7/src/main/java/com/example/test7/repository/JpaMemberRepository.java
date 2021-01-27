package com.example.test7.repository;

import com.example.test7.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        // PK 값으로 찾아야하지만 email 은 pk 값이 아니므로 아래와 같은 방법으로는 불가하다.
//        Member member = em.find(Member.class, email);
//        return Optional.ofNullable(member);

        List<Member> result = em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email).getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findMember(String email, String pwd) {
//        TypedQuery<Member> query = em.createQuery("select m from Member m where m.email = :email and m.password = :pwd", Member.class);
//        System.out.println(query.getResultList());
//        return Optional.empty();

//        List<Member> password = em.createQuery("select m from Member m where m.password = :pwd", Member.class)
//                .setParameter("pwd", pwd).getResultList();
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

}
