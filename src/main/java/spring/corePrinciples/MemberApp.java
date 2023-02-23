package spring.corePrinciples;

import spring.corePrinciples.member.Grade;
import spring.corePrinciples.member.Member;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.BASIC);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
