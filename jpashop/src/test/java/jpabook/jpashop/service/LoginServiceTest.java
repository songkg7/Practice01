package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LoginServiceTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberService memberService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 인증() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");
        member.setEmail("songkg@naver.com");
        member.setPassword("12345");

        // join 할 때 암호화 작동
        memberService.join(member);

        // when
        boolean matches = passwordEncoder.matches("12345", member.getPassword());

        // then
        assertTrue(matches);
    }

    @Test
    public void authenticateFunctionTest() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");
        member.setEmail("songkg@naver.com");
        member.setPassword("12345");

        // join 할 때 암호화 작동
        memberService.join(member);

        // when
        boolean authenticate = loginService.authenticate(member.getEmail(), "12345");

        // then
        assertTrue(authenticate);

    }

}