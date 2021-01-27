package com.example.test7.controller;

import com.example.test7.domain.Member;
import com.example.test7.repository.JpaMemberRepository;
import com.example.test7.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class MemberController {

    private final JpaMemberRepository memberRepository;
    private final MemberService memberService;

    public MemberController(MemberService memberService, JpaMemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @RequestMapping("/")
    private String login() {
        return "login";
    }

    @GetMapping("signUp")
    public String createMember() {
        return "members/createMemberForm";
    }

    @PostMapping("signUp")
    public String create(MemberForm form) {
        Member member = new Member(form.getInputEmail(), form.getInputPassword(), form.getName());

        // 받아온 데이터로 실제 회원 등록
        // controller 에서 service 로 넘기는 구간이다
        memberService.join(member);

        return "redirect:/";
    }

    // Login
    // FIXME: Login 기능 미구현 상태
    @PostMapping("signIn")
    private String login(String inputEmail, String inputPassword) {
        log.info("id : {}, pw : {}", inputEmail, inputPassword);
        Optional<Member> member = this.memberRepository.findMember(inputEmail, inputPassword);
        if (member.isPresent()) {
            return "board";
        } else {
            return "redirect:/";
        }
    }

    // 회원 목록
    @GetMapping("/members")
    public String memberList(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
