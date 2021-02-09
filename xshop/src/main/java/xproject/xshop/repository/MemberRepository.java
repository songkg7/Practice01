package xproject.xshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xproject.xshop.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
