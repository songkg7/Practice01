package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public boolean authenticate(String email, String password) {
        Optional<Member> findMembers = memberRepository.findByEmail(email);
        if (findMembers.isPresent()) {
            Member member = findMembers.get();
            return passwordEncoder.matches(password, member.getPassword());
        } else {
            // FIXME: null check 의 좀 더 깔끔한 방법 찾아보기
            return false;
        }
    }
}
