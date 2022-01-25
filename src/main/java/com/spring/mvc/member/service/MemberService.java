package com.spring.mvc.member.service;


import com.spring.mvc.member.domain.Member;
import com.spring.mvc.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }
    //회원가입
    public void register(Member member){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(member.getPassword());
        member.setPassword(encodePassword);
        memberRepository.register(member);
    }
    //아이디 중복확인
    public int isDuplicateId(String inputKeyword){
        memberRepository.isDuplicateId(inputKeyword);
        int result = memberRepository.isDuplicateId(inputKeyword);
        return result;
    }
    //이메일 중복확인
    public int isDuplicateEmail(String inputKeyword){
        memberRepository.isDuplicateEmail(inputKeyword);
        int result2 = memberRepository.isDuplicateEmail(inputKeyword);
        return result2;
    }
    // 단일 회원정보 확인
    public Member findMember(String account){
        return memberRepository.findMember(account);
    }
}
