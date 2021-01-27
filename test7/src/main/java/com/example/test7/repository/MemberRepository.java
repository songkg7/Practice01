package com.example.test7.repository;

import com.example.test7.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByName(String name);

    Optional<Member> findMember(String email, String pwd);

    List<Member> findAll();
}
