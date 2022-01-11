package com.spring.mvc.basic.controller.v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BasicV2Controller {

    //ResponseBody를 붙이면 문자열이 그대로 브라우저에게 전달됨
    // 떼면 해당 문자열의 경로에 있는 파일을 열어줌
    @GetMapping("/join")
    public String join(){
        return "/register.html"; //열어줄 파일의 경로
    }

    @GetMapping("/gugudan")
    public String gugudan(){
        return "/common/gugu3.html"; //폴더 안에있으면 폴더명까지 입력
    }
}
