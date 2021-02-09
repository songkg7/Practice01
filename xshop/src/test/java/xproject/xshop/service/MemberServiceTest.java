package xproject.xshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xproject.xshop.domain.Member;
import xproject.xshop.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        // given
        Member member = new Member();


        // when


        // then
    }

}