package com.example.test7.controller;

import com.example.test7.domain.Member;
import com.example.test7.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("members/new")
    public String createMember() {
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
//        System.out.println(form.getName());
        member.setPassword(form.getPwd());

        // 받아온 데이터로 실제 회원 등록
        // controller 에서 service 로 넘기는 구간이다
        memberService.join(member);

        return "redirect:/";
    }
}
