package spring.corePrinciples.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.corePrinciples.member.Grade;
import spring.corePrinciples.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("등급에 따라 다른 할인율이 적용되는지")
    void discount() {
        //given
        Long memberId = 1L;
        Member member = new Member(1L, "Spring", Grade.VIP);
        Member member2 = new Member(1L, "Spring", Grade.BASIC);
        //when
        double discountedPrice = discountPolicy.discount(member, 10000);
        double discountedPrice2 = discountPolicy.discount(member2, 10000);

        //then
        Assertions.assertThat(discountedPrice).isEqualTo(9000);
        Assertions.assertThat(discountedPrice2).isEqualTo(10000);
    }

    @Test
    @DisplayName("등급에 따라 다른 할인율이 적용되는지2")
    void discount2() {
        //given
        Long memberId = 1L;
        Member member = new Member(1L, "Spring", Grade.VIP);
        Member member2 = new Member(1L, "Spring", Grade.BASIC);
        //when
        double discountedPrice = discountPolicy.discount(member, 10000);
        double discountedPrice2 = discountPolicy.discount(member2, 10000);

        //then
        Assertions.assertThat(discountedPrice).isNotEqualTo(10000);
    }
}