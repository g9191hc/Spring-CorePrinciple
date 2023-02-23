package spring.corePrinciples.discount;

import spring.corePrinciples.member.Member;

public interface DiscountPolicy {
    double discount(Member member, double price);
}
