package spring.corePrinciples.service;

import spring.corePrinciples.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
