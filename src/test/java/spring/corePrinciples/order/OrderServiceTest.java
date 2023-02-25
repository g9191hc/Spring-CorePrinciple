package spring.corePrinciples.order;

import org.junit.jupiter.api.Test;
import spring.corePrinciples.AppConfig;
import spring.corePrinciples.member.Grade;
import spring.corePrinciples.member.Member;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.OrderService;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {
    AppConfig ac = new AppConfig();
    MemberService memberService = ac.memberService();
    OrderService orderService = ac.orderService();
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
