package spring.corePrinciples.discount;

import org.springframework.stereotype.Component;
import spring.corePrinciples.annotations.MainDiscountPolicy;
import spring.corePrinciples.member.Grade;
import spring.corePrinciples.member.Member;


@Component
@MainDiscountPolicy
public class FixedDiscountPolicy implements DiscountPolicy{
    private int discountPrice = 1000;
    @Override
    public double discount(Member member, double price) {
        if(member.getGrade() == Grade.VIP) return price - discountPrice;
        else return price;
    }
}
