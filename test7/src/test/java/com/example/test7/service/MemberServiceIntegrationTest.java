package com.example.test7.service;

import com.example.test7.domain.Member;
import com.example.test7.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setEmail("songkg9@gmail.com"); // PK 값으로 테스트 실행
        member.setPassword("12341234");
        //When
        String saveMember = memberService.join(member);
        //Then
        Member findMember = memberRepository.findByEmail(saveMember).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
//        //Given
//        Member member1 = new Member();
//        member1.setEmail("spring");
//        Member member2 = new Member();
//        member2.setEmail("spring");
//        //When
//        memberService.join(member1);
//        IllegalStateException e = assertThrows(IllegalStateException.class,
//                () -> memberService.join(member2)); //예외가 발생해야 한다. assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
