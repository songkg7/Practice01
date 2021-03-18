package jpabook.jpashop.controller;

import jpabook.jpashop.service.LoginService;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "auth/login";
    }

    @PostMapping("/login")
    public String loginProcess(LoginForm form) {

//        log.info(form.getEmail());
//        log.info(form.getPassword());
        if (loginService.authenticate(form.getEmail(), form.getPassword())) {
            return "redirect:/";
        } else {
            // login 에 실패하면 회원가입 화면으로 이동
            return "redirect:members/createMemberForm";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
