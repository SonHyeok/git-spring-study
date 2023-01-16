package springSTD.study.repository;

import springSTD.study.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 뭐지
    private static long sequence = 0L; // 뭐지


    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 아이디 값 세팅
        store.put(member.getId(), member); // store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 반환값이 null이라도 optional로 감싸서 반환 가능하게 만듬
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // stream이 뭐지
                .filter(member -> member.getName().equals(name))
                .findAny(); // 반복하면서 파라미터로 넘어온 member값과 같은 것 발견시 바로 반환.
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



