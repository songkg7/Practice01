package xproject.xshop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
// FIXME: Setter 는 생성하지 않는 것이 좋으니 나중에 리팩토링하자
// comment 부분으로 미리 만들어두었다.
@Setter
//@NoArgsConstructor
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @Embedded
    private Address address;

    // 계정 권한 (Spring Security)
    private String authority;

    // 계정 활성화 상태 (Spring Security)
    private boolean enabled;

    // 계정이 갖고 있는 권한 목록을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 목록을 담아두는 객체 생성
        ArrayList<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority(authority));
        return auth;
    }

    @Override
    public String getUsername() {
        return email;
    }

    // 계정이 만료되지 않았는지 리턴 (true : 만료되지 않음)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있지 않은지 리턴 (true : 잠겨있지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호가 만료되지 않았는지 리턴 (ture : 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화(사용가능)인지 리턴 (true : 활성화)
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /*

    @Builder
    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }
*/
}
