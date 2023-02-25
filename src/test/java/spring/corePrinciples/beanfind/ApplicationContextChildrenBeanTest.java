package spring.corePrinciples.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import spring.corePrinciples.discount.DiscountPolicy;
import spring.corePrinciples.discount.FixedDiscountPolicy;
import spring.corePrinciples.discount.RateDiscountPolicy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextChildrenBeanTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(InnerAppConfig.class);

    @Test
    @DisplayName("자식빈 조회 확인")
    void findByTypeOfParent(){
        assertThrows(NoUniqueBeanDefinitionException.class, ()->ac.getBean(DiscountPolicy.class));
        Map<String, DiscountPolicy> discountPolicy = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(discountPolicy.size()).isEqualTo(2);
    }

    @Configuration
    static class InnerAppConfig {
        @Bean
        DiscountPolicy discountPolicy1() {
            return new RateDiscountPolicy();
        }

        @Bean
        DiscountPolicy discountPolicy2() {
            return new FixedDiscountPolicy();
        }
    }
}
