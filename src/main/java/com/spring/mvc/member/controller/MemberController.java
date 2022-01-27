package com.spring.mvc.member.controller;

import com.spring.mvc.member.domain.Member;
import com.spring.mvc.member.service.LoginFlag;
import com.spring.mvc.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
//@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //회원가입 화면 열기
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
    //로그인 화면 열기
    @GetMapping("/login")
    public String logIn(){
        return "member/login";
    }
    //로그인 요청 처리
    @PostMapping("/loginCheck")
    public String login(String account , String password, Model model, HttpSession session){ //세션 이용
        log.info("/loginCheck POST -" + account + ", " + password);
        LoginFlag flag = memberService.login(account, password);
        model.addAttribute("msg",flag);

        //로그인 성공 시
        if(flag == LoginFlag.SUCCESS) {
            //model에 저장하는것이아닌 session에 setAttribute에 로그인 정보를 기록
            session.setAttribute("loginUser", memberService.getMember(account)); 
            return "redirect:/"; //이제 정보가 사라지지않아서 redirect 사용 가능
        }

        //아이디 또는 비번이 틀린 경우
        return "member/login";
    }

    //로그아웃 요청
    @GetMapping("/sign-out")
    public String signOut(HttpSession session){
        Member loginUser = (Member) session.getAttribute("loginUser"); //다형성으로 인한 강제형변환
        if(loginUser != null) {
            session.removeAttribute("loginUser");
            session.invalidate(); //세션 무효화
        }
        return "redirect:/";
    }

}
