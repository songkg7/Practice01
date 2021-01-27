package com.example.test7.domain;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Member {

    // primary key setting
    @Id
    // 고유 아이디 자동 부여
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;
    @NotEmpty
    private String email;
    // oracle 에서 숫자 타입 중 앞자리가 0이 붙으면 생략되므로 비밀번호는 String type 으로 생성해야한다.
//    @Size(min=6, max=20, message="비밀번호는 최소 6자리를 입력해야합니다.")
    @NotEmpty
    private String password;

    private String name;

    @Column(name = "Reg_Date")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate date;

    public Member(@NotEmpty String email, @NotEmpty String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.date = LocalDate.now();
    }

}
