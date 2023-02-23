package spring.corePrinciples.order;

import spring.corePrinciples.member.Member;

public class Order {
    private String itemName;
    private Long memberId;
    private double itemPrice;
    private double discountedPrice;

    public Order(String itemName, Long memberId, double itemPrice, double discountedPrice) {
        this.itemName = itemName;
        this.memberId = memberId;
        this.itemPrice = itemPrice;
        this.discountedPrice = discountedPrice;
    }

    double caclulatePrice(){
        return discountedPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemName='" + itemName + '\'' +
                ", memberId=" + memberId +
                ", itemPrice=" + itemPrice +
                ", discountedPrice=" + discountedPrice +
                '}';
    }
}
