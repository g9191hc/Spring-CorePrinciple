package spring.corePrinciples.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.corePrinciples.discount.DiscountPolicy;
import spring.corePrinciples.member.Member;
import spring.corePrinciples.order.Order;
import spring.corePrinciples.repository.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(long memberId, String itemName, double itemPrice) {
        Member member = memberRepository.findById(memberId);
        double discountedPrice = discountPolicy.discount(member, itemPrice);

        return new Order(itemName, memberId, itemPrice, discountedPrice);
    }
}
