package spring.corePrinciples.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.corePrinciples.member.Grade;
import spring.corePrinciples.member.Member;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.MemberServiceImpl;
import spring.corePrinciples.service.OrderService;
import spring.corePrinciples.service.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
@Test
    void CreateOrder(){
    Long memberId = 1L;
    Member memberVip = new Member(memberId, "Spring", Grade.VIP);
    memberId ++;
    Member memberBasic = new Member(memberId, "Spring", Grade.BASIC);

    memberService.join(memberVip);
    memberService.join(memberBasic);
    Order order1 = orderService.createOrder(1L,"Apple",  5000);
    Order order2 = orderService.createOrder(2L,"Grape",  10000);
    assertThat(order1.getDiscountedPrice()).isEqualTo(4000);
    assertThat(order2.getDiscountedPrice()).isEqualTo(10000);

}


}
