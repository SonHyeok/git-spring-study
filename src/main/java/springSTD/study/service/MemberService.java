package springSTD.study.service;

import springSTD.study.domain.Member;
import springSTD.study.repository.MemberRepository;
import springSTD.study.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // ctrl + alt + shift + t 하면 만들어놓은 기능을 메소드로 추출 가능
    private void validateDuplicateMember(Member member) { // 중복검사 메소드
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { // ifPresent는 같은 이름 존재하는지 확인하는 메소드
                    throw new IllegalStateException("이미 존재하는 회원입니다."); // 이미 존재하는 데이터에 대한 예외처리
                    }); // ctrl + alt + v 하면 변수 자동생성해줌
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
