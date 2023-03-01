package scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean bean1 = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);
        Assertions.assertThat(bean1).isSameAs(bean2);
        ac.close();
    }
    @Scope("singleton") // default가 singleton이라 @Scope 애노테이션 및 "singleton"명시가 필요 없지만 적음
    static class SingletonBean{
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
