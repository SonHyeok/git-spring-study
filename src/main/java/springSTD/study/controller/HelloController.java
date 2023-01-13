package springSTD.study.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        //@RequestParam = 웹에서 파라미터 받는 어노테이션
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-mvc-t")
    public String helloMvct(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 head와 body 중에서 body에 직접 데이터를 넣겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello! " + name;
    }

    @GetMapping("hello-string-t")
    @ResponseBody
    public String helloStringt(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); //Hello class 객체 생성 (스프링은 객체를 생성하면 객체에서 생성되는 데이터는 json형태로 받음)
        hello.setName(name); // 파라미터로 받은 데이터를 이름으로 설정
        return hello; // 설정된 이름 반환
    }

    static class Hello { // Hello 클래스
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @GetMapping("hello-api-t")
    public String helloTestApi(@RequestParam("name") String name, Model model){ // 받은 파라미터를 모델에 저장하여 getter setter 사용해서
        Hellotest hellot = new Hellotest();                                     // name 설정과 모델에 추가, 그 후 페이지에 띄워줌
        hellot.setNames(name);
        model.addAttribute("name",hellot.getNames());
        return "hello-template";
    }

        static class Hellotest{ // getter setter 사용할 클래스 생성
            private String names;

            public String getNames() {
                return names;
            }

            public void setNames(String names) {
                this.names = names;
            }
        }


    @GetMapping("ht")
    @ResponseBody
    public Hellotest ht(@RequestParam("name") String name){
        Hellotest hts = new Hellotest();
        hts.setNames(name);
        return hts;
    }
}
