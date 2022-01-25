package com.spring.mvc.member.controller;

import com.spring.mvc.member.domain.Member;
import com.spring.mvc.member.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //로그인 화면 열기
    @GetMapping("/login")
    public String logIn(){
        return "member/login";
    }
    //회원가입 화면 열기기
   @GetMapping("/signUp")
    public String signUp(){
        return "member/signUp";
    }

    @PostMapping("/signUp")
    public String signUpPage(Member member){
        log.info(member);
        memberService.register(member);
        return "redirect:/";
    }

    /*@GetMapping("/find")
    public String inquiry(String account,Model model){
        model.addAttribute("")
    }*/




}
