package spring.corePrinciples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.corePrinciples.discount.DiscountPolicy;
import spring.corePrinciples.discount.FixedDiscountPolicy;
import spring.corePrinciples.repository.MemberRepository;
import spring.corePrinciples.repository.MemoryMemberRepository;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.MemberServiceImpl;
import spring.corePrinciples.service.OrderService;
import spring.corePrinciples.service.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixedDiscountPolicy();
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
