package xproject.xshop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;
import xproject.xshop.domain.Member;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//@Transactional @DataJpaTest 는 기본적으로 transactional 어노테이션을 포함하고 있다. 직접 달아줄 필요가 없다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class JpaTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void Member_저장() throws Exception {
        // given
        Member member = new Member();
        member.setUsername("memberA");

        // when
        testEntityManager.persist(member);

        // then
        assertEquals(member, testEntityManager.find(Member.class, member.getId()));

    }
}
