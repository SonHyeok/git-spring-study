package springSTD.study.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import springSTD.study.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 하나의 메소드가 돌아간 후 저장된 데이터를 모두 클리어 한다는 어노테이션
    public void afterEach(){
        repository.clearStore(); // 저장소 초기화
    }

    @Test
    public void save(){ // 데이터 저장 메소드(테스트)
        Member member = new Member();
        member.setName("Spring"); // 이름 설정

        repository.save(member); // 저장소에 저장

        Member result = repository.findById(member.getId()).get(); // 위에서 설정한 이름의 시스템 내부 아이디로 설정된 이름 변수에 저장
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("son");
        repository.save(member1);

        Member member2 = new Member(); // shift + f6으로 같은 이름 변경가능
        member2.setName("son2");
        repository.save(member2);

        Member result = repository.findByName("son").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("son");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("son2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2); // 개수 체크
    }
}
