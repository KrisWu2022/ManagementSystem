package com.example.ordersystem.order;

public class OrderNotFoundException extends Throwable {

    public OrderNotFoundException(String message) {
        super(message);
    }
}
