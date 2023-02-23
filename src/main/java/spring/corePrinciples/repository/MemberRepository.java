package spring.corePrinciples.repository;

import spring.corePrinciples.member.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
