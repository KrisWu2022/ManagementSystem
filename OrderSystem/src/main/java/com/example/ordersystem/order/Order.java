package com.example.ordersystem.order;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String order_name;

    private String customer;

    private Date date;

    private Integer orderline;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public Integer getOrderline() {
        return orderline;
    }

    public void setOrderline(Integer orderline) {
        this.orderline = orderline;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_name='" + order_name + '\'' +
                ", customer='" + customer + '\'' +
                ", date=" + date +
                ", orderline=" + orderline +
                '}';
    }
}
