package springSTD.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springSTD.study.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // memberService를 스프링에서 자동으로 MemberController와 연결해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
