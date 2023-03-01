package spring.corePrinciples.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.corePrinciples.AutoAppConfig;
import spring.corePrinciples.repository.MemoryMemberRepository;

class AutoAppConfigTest{
    @Test
    void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemoryMemberRepository bean = ac.getBean(MemoryMemberRepository.class);
        Assertions.assertThat(bean).isInstanceOf(MemoryMemberRepository.class);
    }
}