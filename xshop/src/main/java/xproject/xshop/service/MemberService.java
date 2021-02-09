package xproject.xshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xproject.xshop.domain.Member;
import xproject.xshop.repository.MemberRepository;

@Service
@RequiredArgsConstructor // 생성자를 통한 의존성 주입을 위한 어노테이션
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Long save(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    // Member 를 리턴해주지만 Member 는 UserDetails 를 구현하고 있다.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findByEmail(email);
    }
}
