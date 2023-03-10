package spring.corePrinciples.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.corePrinciples.AppConfig;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }@Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        //ac.getBean("xxxx",MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxx", MemberService.class));
    }
    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
