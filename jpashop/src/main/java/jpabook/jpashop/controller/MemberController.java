package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.LoginService;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final LoginService loginService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

//        log.info(form.getEmail());

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        // FIXME: setter 를 최대한 활용하지 않는 방향으로 리팩토링 하는 것이 좋다. MemberDTO 를 만들어서 해결해보자
//        Member member = new Member(form.getName(), form.getEmail(), form.getPassword(), address);
        Member member = new Member();
        member.setName(form.getName());
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    // 회원 탈퇴
    @GetMapping("/members/delete")
    public String deleteMemberForm(Model model, Principal principal) {
        String email = principal.getName();
        Member member = memberService.findByEmail(email);

        model.addAttribute("member", member);

        return "members/deleteMemberForm";
    }

    @PostMapping("/members/delete")
    public String deleteMember(Principal principal, @RequestParam("password") String password) {
        log.info("input password : " + password);

        String email = principal.getName();
        Member member = memberService.findByEmail(email);

        // password 의 일치 여부 검사
        if (loginService.authenticate(email, password)) {
            // 데이터베이스에서 값 삭제
            memberService.delete(member);
            // 로그아웃
            return "redirect:/logout";
        } else {
            return "redirect:/";
        }
    }
}
