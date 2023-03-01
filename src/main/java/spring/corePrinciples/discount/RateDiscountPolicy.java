package spring.corePrinciples.discount;

import org.springframework.stereotype.Component;
import spring.corePrinciples.member.Grade;
import spring.corePrinciples.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy{
    double discountRate = 0.1;
    @Override
    public double discount(Member member, double price) {
        if(member.getGrade() == Grade.VIP) return price * (1-discountRate);
        else return price;
    }
}
