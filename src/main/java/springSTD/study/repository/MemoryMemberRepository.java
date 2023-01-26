package springSTD.study.repository;

import org.springframework.stereotype.Repository;
import springSTD.study.domain.Member;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 회원 아이디와 값
    private static long sequence = 0L; // 뒤에 붙은 L은 변수의 형태가 Long형이라고 표시해주는 것

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 반환값이 null이라도 optional로 감싸서 반환 가능하게 만듬
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // stream은 내부 반복 작업을 함
                .filter(member -> member.getName().equals(name))
                .findAny(); // stream으로 반복하면서 파라미터로 넘어온 member값과 같은 것 발견시 바로 반환.
                            // 같은 값 없을시 optional로 감싸진 null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 member들을 리스트로 반환
    }

    public void clearStore() { // 저장소에 저장된 데이터 초기화하는 메소드
        store.clear();
    }
}



