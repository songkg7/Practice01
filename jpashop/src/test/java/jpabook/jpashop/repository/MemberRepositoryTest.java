package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void 이메일검색() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");
        member.setEmail("songkg@naver.com");
        member.setPassword(passwordEncoder.encode("12345"));
        memberService.join(member);

        // when
        List<Member> findMember = memberRepository.findByEmail(member.getEmail());
        if (!findMember.isEmpty()) {
            String email = findMember.get(0).getEmail();
            assertEquals(member.getEmail(), email);
        }

        // then

    }


}