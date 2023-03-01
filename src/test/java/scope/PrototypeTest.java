package scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.naming.spi.ObjectFactory;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        Assertions.assertThat(bean1).isNotSameAs(bean2);
        ac.close();
    }
    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        void init() {
            System.out.println("singletonBean.init");
        }

        @PreDestroy
        void close() {
            System.out.println("singletonBean.close");
        }
    }
}
