package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager em;

    @Test
//    @Rollback(false)
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");
        member.setEmail(null);

        // when
        Long savedId = memberService.join(member);

        // then
        assertEquals(member, memberRepository.findOne(savedId));


    }

//    @Test(expected = IllegalStateException.class) // 주석 부분을 왼쪽처럼 적는 것으로 대체 가능 == junit4
    @Test
    public void 증복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        // junit5
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        memberService.join(member1);
//        memberService.join(member2);


//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//
//        } catch (IllegalStateException e) {
//            return;
//        }

        // then
//        fail("예외가 발생해야 한다.");


    }

}