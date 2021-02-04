package jpabook.jpashop;

import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/font/**", "/html/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .authorizeRequests()
                // 인증이 되어있을 때 (Authenticated?)
//                .antMatchers("/").authenticated()
                .antMatchers("/members").hasAuthority("ROLE_ADMIN")
                .antMatchers("/items", "/items/new").authenticated()
                .antMatchers("/board/**").authenticated()
                .antMatchers("/order", "/orders").authenticated()

                // ADMIN Authorization(ADMIN 권한, ROLE_ADMIN) - 3가지 방법
                //		.antMatchers("/admin/**").hasRole("ROLE_ADMIN")
                //		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN'")
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")

                // 모두 허용 ( 위에서 걸리면(url 매칭)-저기있는 URL이 아니라면, 밑으로 안내려옴 ) - 2가지 방법
                //		.antMatchers("/**").permitAll();
                .anyRequest().permitAll();
//                FIXME: 403 error 를 해결하기 위해 csrf 를 disable 하는 옵션은 보안상 문제가 생길 수 있기 때문에 다른 방법을 찾자
//            .and()
//                .csrf().disable();

        http
                .formLogin()
                .loginPage("/login") 	// 로그인 페이지 url
                .loginProcessingUrl("/login")  // view form 의 action 과 맞아야함
                .failureUrl("/login") // 로그인 실패시 redirect
                .defaultSuccessUrl("/", true) // 로그인 성공시

                // 로그인 요청시 id용 파라미터 (메소드 이름이 usernameParameter 로 무조건 써야하지만, 파라미터는 email 이든 id 이든 name 이든 상관없다.)
                .usernameParameter("email")
                .passwordParameter("password");	// 로그인 요청시 password 용 파라미터

        // 3. 로그아웃 설정
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/") // 로그아웃 성공시
                .invalidateHttpSession(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자 세부 서비스를 설정하기 위한 오버라이딩이다.

        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
}
