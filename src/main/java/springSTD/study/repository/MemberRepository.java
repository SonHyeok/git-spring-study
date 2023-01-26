package springSTD.study.repository;

import springSTD.study.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // null 값 return을 방지하기 위해서 Optional로 감싸줌
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
