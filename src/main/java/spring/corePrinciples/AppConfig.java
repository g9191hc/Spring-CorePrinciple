package spring.corePrinciples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.corePrinciples.discount.DiscountPolicy;
import spring.corePrinciples.discount.FixedDiscountPolicy;
import spring.corePrinciples.discount.RateDiscountPolicy;
import spring.corePrinciples.repository.MemoryMemberRepository;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.memberServiceImpl;
import spring.corePrinciples.service.OrderService;
import spring.corePrinciples.service.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public static DiscountPolicy discountPolicy(){
        return new FixedDiscountPolicy();
    }
    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public MemberService memberService(){
        return new memberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
