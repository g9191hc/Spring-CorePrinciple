package spring.corePrinciples.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;
// Qualifier의 애노테이션 복사 시작
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
// Qualifier.java의 애노테이션 복사 끝 (shift + shift => @Qualifier로 이동 )
@Qualifier("mainDiscountPolicy") //원하는 구분자 이름으로 @Qualifier 애노테이션 추가
public @interface MainDiscountPolicy {
}
