package springSTD.study.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springSTD.study.domain.Member;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();


    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("son");


        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member);
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}