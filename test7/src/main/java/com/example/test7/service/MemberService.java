package com.example.test7.service;

import com.example.test7.domain.Member;
import com.example.test7.repository.JpaMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final JpaMemberRepository memberRepository;

    public MemberService(JpaMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // join method 를 통해 저장 후 id 값을 return
    public String join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증 memberRepository.save(member);
        // controller 를 통해 전달받은 계정 정보를 저장
        memberRepository.save(member);
        return member.getEmail();
    }

    // 중복회원 검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId) {
        return memberRepository.findByEmail(memberId);
    }
}
