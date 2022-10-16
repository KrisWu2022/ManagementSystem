package com.example.ordersystem.orderline;

import javax.persistence.*;

@Entity
@Table(name="orderlines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer orderline;

    private String product;

    private int quantity;

    public Integer getOrderline() {
        return orderline;
    }

    public void setOrderline(Integer orderline) {
        this.orderline = orderline;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderline=" + orderline +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
