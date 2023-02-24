package spring.corePrinciples.service;

import spring.corePrinciples.member.Member;
import spring.corePrinciples.repository.MemberRepository;

public class memberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public memberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
 
}
