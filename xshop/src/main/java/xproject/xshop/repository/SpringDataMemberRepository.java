package xproject.xshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xproject.xshop.domain.Member;

public interface SpringDataMemberRepository extends JpaRepository<Member, Long> {

}
