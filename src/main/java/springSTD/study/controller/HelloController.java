package springSTD.study.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello/") // get/post 방식에서 get을 의미함 8080/뒤에 오는 url을 구분
    public String hello(Model model){
        model.addAttribute("data","spring!!"); // spring!! 이 값이 hello.html에서 ${data}부분에 들어감.
        return "hello"; // templates 디렉토리 내부에 hello.html 찾아간 것
        // return시에는 항상 viewResolver가 templates 내부에서 html파일을 찾음(spring 구조가 그렇게 짜임)
    }

    @GetMapping("sonny/")
    public String sonny(Model model) {
        model.addAttribute("data", "sonny! welcome!!");
        return "sonny";
    }
}
