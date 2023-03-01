package spring.corePrinciples.autowired;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spring.corePrinciples.AutoAppConfig;
import spring.corePrinciples.discount.DiscountPolicy;
import spring.corePrinciples.member.Grade;
import spring.corePrinciples.member.Member;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllBeansTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        DiscountService ds = ac.getBean(DiscountService.class);
//        System.out.println(ds);
        Member member = new Member(1L, "cus1", Grade.VIP);
        System.out.println(ds);
        Assertions.assertThat(ds.discount(member, 5000, "fixedDiscountPolicy")).isEqualTo(4000);
        Assertions.assertThat(ds.discount(member, 5000, "rateDiscountPolicy")).isEqualTo(4500);
    }

    @RequiredArgsConstructor
    @Component
    static class DiscountService{
        private final Map<String, DiscountPolicy> discountMap;
        private final List<DiscountPolicy> discountList;
        private final Set<DiscountPolicy> discountSet;

        public double discount(Member member, double price, String discountPolicyName){
            DiscountPolicy discountPolicy = discountMap.get(discountPolicyName);
            return discountPolicy.discount(member,price);
        }

        @Override
        public String toString() {
            return "DiscountService{" +
                    "\n\tdiscountMap=" + discountMap +
                    "\n\tdiscountList=" + discountList +
                    "\n\tdiscountSet=" + discountSet +
                    "\n}";
        }
    }

}
