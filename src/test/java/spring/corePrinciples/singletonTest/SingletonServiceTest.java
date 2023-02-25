package spring.corePrinciples.singletonTest;

import com.sun.source.tree.UsesTree;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.corePrinciples.AppConfig;
import spring.corePrinciples.repository.MemberRepository;
import spring.corePrinciples.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

public class SingletonServiceTest {
    @Test
    @DisplayName("싱글톤패턴 싱글톤 검증")
    void singletonTest(){
        SingletonService singletonService1 = SingletonService.getSingletonService();
        SingletonService singletonService2 = SingletonService.getSingletonService();
        assertThat(singletonService1).isSameAs(singletonService2);
    }


    @Test
    @DisplayName("스프링 싱글톤 검증")
    void springSingletonTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberRepository mr1 = ac.getBean("memberRepository", MemoryMemberRepository.class);
        MemberRepository mr2 = ac.getBean("memberRepository", MemoryMemberRepository.class);
        assertThat(mr1).isSameAs(mr2);
    }
}

