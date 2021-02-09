package xproject.xshop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xproject.xshop.domain.Member;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
/*
    @Test
    public void testMember() {
        Member member = new Member();
        member.setUsername("memberA");
        Long savedId = memberRepository.save(member);

        Member findMember = memberRepository.find(savedId);

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);

    }
*/

    @Test
    public void testSpringDataJPA() {
        Member member = new Member();
        member.setName("memberB");
        Member savedMember = memberRepository.save(member);

        Optional<Member> findMember = memberRepository.findById(savedMember.getId());

        findMember.ifPresent(value -> assertThat(value.getUsername()).isEqualTo(member.getUsername()));

    }


}