package com.spring.mvc.basic.controller.v2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BasicV2Controller {

    //ResponseBody를 붙이면 문자열이 그대로 브라우저에게 전달됨
    // 떼면 해당 문자열의 경로에 있는 파일을 열어줌
    @GetMapping("/join1")
    public String join() {
        return "/register.html"; //열어줄 파일의 경로
    }

    @GetMapping("/gugudan")
    public String gugudan() {
        return "/common/gugu3.html"; //폴더 안에있으면 폴더명까지 입력
    }

    @GetMapping("/gugu7")
    public String gugu7() {
        return "/WEB-INF/views/gugu7.jsp";
    }

    //요청 파라미터 읽기(쿼리스트링 읽기): 클라이언트가 서버로 전송한 데이터
    // www.abc.com/v2/hello?pet=dog&name=뽀삐 <-- pet, name 정보 얻어내기
    @GetMapping("/v2/hello")
    public String hello(@RequestParam("p") String pet, int age) {
        System.out.println("/v2/hello 요청이 들어옴~!!");
        System.out.println("pet = " + pet);
        System.out.println("age = " + age);
        return "";
    }

    //요청 파라미터가 많을 경우 객체를 이용
    //서버에서 클라이언트로 데이터를 보내는 방법
    //Model 객체를 활용

    //같은 폴더안에 클래스를 만들어서 필드를 생성하고 불러온다.
    @PostMapping("/pet/info")  //GetMapping에서 PostMapping으로 변경 하는 이유
    //GET으로 받으면 정보가 공개되버려서 보안에 위험이 있기에 POST로
    public String pet(PetInfo petInfo, Model model) { // <- 삽입
        //jsp파일에게 데이터를 전송
        model.addAttribute("pi", petInfo);
        System.out.println(petInfo);
        return "/WEB-INF/views/pet-result.jsp"; // jsp가 없으면 404에러가 뜬다.
    }

    @GetMapping("/pet/form")
    public String petForm() {
        return "/WEB-INF/views/pet-form.jsp";
    }

    //============== 실습 문제 =====================//

    /*
        1. 우선 resgister.jsp를 열어주는 요청 메서드를 작성하세요.
        URL: /user/form 입니다.

        2. 사용자가 form에 등록한 회원정보를 받아서 처리하는 요청 메서드를 작성하세요.
        URL: /user/join 입니다.

        3. 2번 요청이 끝난 후 user-result.jsp로 이동시키시고 해당 파일에서는 회원의 정보를 출력해보세요
            ex> 아이디는 ??이고 비밀번호는 ?? 입니다 어쩌고~~

     */

    @GetMapping("/user/form")
    public String userForm(){
        return "/WEB-INF/views/register.jsp";
    }

    @PostMapping("/user/join")
    public String userJoin(User userInfo, Model model) {
        model.addAttribute("ui",userInfo);
        System.out.println(userInfo);
        return "user-result";

    }

    @GetMapping("/user/bmi")
    public String userBmi(){
        return "user-form";
    }

    @PostMapping("/user/confirm")
    public String userConfirm(UserBmi userBmi,Model model){
        //공식 : kg /(m * n)
        double kg = userBmi.getWeight();
        double m = userBmi.getHeight() /100;
        double bmi = kg / (m * m);
        //반올림
        bmi = Math.round(bmi*100)/100.00;

        model.addAttribute("userName",userBmi.getUserName());
        model.addAttribute("height",userBmi.getHeight());
        model.addAttribute("weight",userBmi.getWeight());
        model.addAttribute("bmi", bmi);

        System.out.println(userBmi);
        return "user-bmi";
    }

    //사용자에게 키(cm)랑 몸무게(kg),이름을 입력받아서
    // 결과페이지에서 bmi를 알려주세요~

    // ex) xxx님의 bmi지수는 xxx입니다.
//    bmi = kg/(m*m)

}
