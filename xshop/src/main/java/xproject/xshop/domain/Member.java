package xproject.xshop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
// FIXME: Setter 는 생성하지 않는 것이 좋으니 나중에 리팩토링하자
// comment 부분으로 미리 만들어두었다.
@Setter
//@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    /*
    private String password;

    @Builder
    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }
*/
}
