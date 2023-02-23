package spring.corePrinciples.service;

import spring.corePrinciples.member.Member;
import spring.corePrinciples.order.Order;

public interface OrderService {
    Order createOrder(long memberId, String itemName, double itemPrice);
}
