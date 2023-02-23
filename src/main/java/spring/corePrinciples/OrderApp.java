package spring.corePrinciples;

import spring.corePrinciples.member.Grade;
import spring.corePrinciples.member.Member;
import spring.corePrinciples.order.Order;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.MemberServiceImpl;
import spring.corePrinciples.service.OrderService;
import spring.corePrinciples.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        String memberName = "spring";
        Grade grade = Grade.VIP;
        Member member = new Member(memberId, memberName, grade);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "apple", 5000);
        System.out.println(order.getDiscountedPrice());
        System.out.println("order = " + order);
    }
}
