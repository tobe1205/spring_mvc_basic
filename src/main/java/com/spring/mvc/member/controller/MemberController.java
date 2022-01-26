package com.spring.mvc.member.controller;

import com.spring.mvc.member.domain.Member;
import com.spring.mvc.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
//@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //로그인 화면 열기
    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    //아이디 중복확인 비동기 통신요청
    @GetMapping("/check")
    @ResponseBody
    public boolean check(String checkId){
        return memberService.isDuplicateId(checkId);
    }
    //이메일 중복확인 비동기 통신요청
    @GetMapping("/check2")
    @ResponseBody
    public boolean check2(String checkEmail){
        return memberService.isDuplicateEmail(checkEmail);
    }
    //회원가입 완료 후, db에 정보 저장
    @PostMapping("/member/sign-up")
    public String signUpPage(Member member){
        log.info("/member/sing-up POST - " + member);
        memberService.register(member);
        return "redirect:/";
    }
    /*//로그인 화면 열기
    @GetMapping("/login")
    public String logIn(){
        return "member/login";
    }*/

    /*//회원가입 화면 열기기
    @GetMapping("/signUp")
    public String signUp(){
        return "member/signUp";
    }*/

    





}
