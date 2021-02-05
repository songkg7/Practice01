package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Role;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder; // Spring Config 와 순환 참조

    /**
    * 회원 가입
    */
    @Transactional
    public Long join(Member member) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        validateDuplicateMember(member); // 중복회원 검증

        // 암호화
        String encodePwd = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodePwd); // JPA 변경감지?, password hashing

        memberRepository.save(member);
        return member.getId();
    }

    /*
     * 회원 탈퇴
     */
    // NOTE: DB 에 DEL_YN 필드를 만들어서 삭제 여부를 Y, N 으로 저장해서 검색시 DEL_YN 필드값이 N 인 회원들을 검색하는게 정석
    @Transactional
    public void delete(Member member) {
        memberRepository.delete(member);
    }


    // 중복회원 검증
    private void validateDuplicateMember(Member member) {

        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    public Member findByEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);

        // FIXME: null 은 예외처리하기
        return member.orElse(null);
    }

    // Spring Security
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findByEmail(userEmail);

        List<GrantedAuthority> authorities = new ArrayList<>();

        // FIXME: 관리자 이메일 부여에 대한 고민해보기, 아래에서는 간단하게 처리하기 위해 직접 부여했다.
        if (("admin@example.com").equals(userEmail)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return member.map(value -> new User(value.getEmail(), value.getPassword(), authorities)).orElse(null);
    }
}
