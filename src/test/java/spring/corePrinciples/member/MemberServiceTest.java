package spring.corePrinciples.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {
    // MemberService를 테스트하므로 MemberService 인스턴스 하나 생성
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member = new Member(1L, "test1", Grade.BASIC);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }
}
