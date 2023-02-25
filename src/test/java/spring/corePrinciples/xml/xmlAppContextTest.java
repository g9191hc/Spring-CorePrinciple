package spring.corePrinciples.xml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.corePrinciples.repository.MemberRepository;
import spring.corePrinciples.repository.MemoryMemberRepository;
import spring.corePrinciples.service.MemberService;
import spring.corePrinciples.service.MemberServiceImpl;

public class xmlAppContextTest {
    ApplicationContext ac = new GenericXmlApplicationContext("xmlAppContext.xml");

    @Test
    @DisplayName("Xml기반 ApplicationContext실행")
    void xmlAppTest() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
    }
}
