package spring.corePrinciples.service;

import spring.corePrinciples.discount.DiscountPolicy;
import spring.corePrinciples.discount.FixedDiscountPolicy;
import spring.corePrinciples.discount.RateDiscountPolicy;
import spring.corePrinciples.member.Member;
import spring.corePrinciples.order.Order;
import spring.corePrinciples.repository.MemberRepository;
import spring.corePrinciples.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();
    @Override
    public Order createOrder(long memberId, String itemName, double itemPrice) {
        Member member = memberRepository.findById(memberId);
        double discountedPrice = discountPolicy.discount(member, itemPrice);

        return new Order(itemName, memberId, itemPrice, discountedPrice);
    }
}
