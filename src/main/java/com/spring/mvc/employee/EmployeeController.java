package com.spring.mvc.employee;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@Log4j2 //로그를 만들어주는 기능
public class EmployeeController {

    //저장소 역할에게 처리를 위임하기 위해 Repository를 Compositon
    private final EmployeeRepository employeeRepository; // 새로 생성하는 것이 아님

    @Autowired //생성자 주입을 위해 생성
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //사원 등록 화면을 열어주는 요청
    @GetMapping("/emp/form")
    public String form(){
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now + " - /emp/form GET 요청!!");
        log.info("/emp/form GET 요청 발생!!");
        return "employee/emp-form"; //앞에 WEB-INF/views/ 가 설정으로 인해 생략한것이니까 꼭 경로 잘 확인할 것!!
        //그리고 뒤에 확장자 명도 생략되어있으니 알아야한다! (.jsp)
    }
    //사원 등록 프로세스 요청
    @PostMapping("/emp/register")
    public String register(Employee employee){
        log.info("/emp/register POST - " + employee);
        //저장 명령
        employeeRepository.save(employee);
        return "redirect:/emp/list"; //요청이 끝난 후 /emp/list로 재요청
    }

    //사원전체조회 요청
    @GetMapping("/emp/list")
    public String list(Model model){
        log.info("/emp/list GET!!");
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("empList",employeeList);
        return "employee/emp-form";
    }

    //삭제 요청
    @GetMapping("/emp/delete")
    public String delete(int empNum){
        log.info("/emp/delete GET");
        employeeRepository.remove(empNum);

        return "redirect:/emp/list";
    }
}
