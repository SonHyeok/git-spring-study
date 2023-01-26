package springSTD.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springSTD.study.repository.MemberRepository;
import springSTD.study.repository.MemoryMemberRepository;
import springSTD.study.service.MemberService;

@Configuration
public class SpringConfig {

    // Bean으로 스프링 빈에 등록할 때는 메소드 형태로 정의하는것이 스프링 규칙이다
    @Bean // 스프링 빈에 등록 요청하는 어노테이션
    public MemberService memberService(){ // controller와 연결됨
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){ // repository 생성 메소드
        return new MemoryMemberRepository();
    }
}
