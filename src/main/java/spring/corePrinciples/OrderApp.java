package spring.corePrinciples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.corePrinciples.member.Grade;
import spring.corePrinciples.member.Member;
import spring.corePrinciples.order.Order;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.memberServiceImpl;
import spring.corePrinciples.service.OrderService;
import spring.corePrinciples.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

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
