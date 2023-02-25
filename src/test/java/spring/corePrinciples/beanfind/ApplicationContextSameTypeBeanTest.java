package spring.corePrinciples.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.corePrinciples.repository.MemberRepository;
import spring.corePrinciples.repository.MemoryMemberRepository;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameTypeBeanTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(InnerAppConfig.class);

    @Test
    @DisplayName("타입조회시 같은 타입의 빈이 2개이상이면 에러발생")
    void findSameTypeBean(){
        assertThrows(
                NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemoryMemberRepository.class)
        );
    }
    @Test
    @DisplayName("타입조회시 같은 타입의 빈이 2개이상이면 이름을 지정하면 됨")
    void findBeanByName(){
        MemoryMemberRepository memberRepository = ac.getBean("memberRepository1",MemoryMemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemoryMemberRepository.class);
    }
    @Test
    @DisplayName("해당타입의 모든 빈 조회")
    void findBeansByType(){
        Map<String, MemoryMemberRepository> beans = ac.getBeansOfType(MemoryMemberRepository.class);
        for (String key : beans.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + beans.get(key));
        }
        assertThat(beans.size()).isEqualTo(2);
    }




    @Configuration
    static class InnerAppConfig{
        @Bean
        MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
